/*
 * Copyright (C) 2014 hefty.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.mobius_java_a.my_pub_sub_tutorial;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;
import org.ros.concurrent.CancellableLoop;
import org.ros.internal.node.client.MasterClient;
import org.ros.internal.node.response.*;
import org.ros.master.client.TopicSystemState;
import org.ros.master.client.SystemState;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Listener extends AbstractNodeMain {
  //HashMap containing sets of publishers and subscribers, keyed to the relevant topic.
  private HashMap<String,List<Set<String>>> topicPubSub;

  public HashMap<String,List<Set<String>>> getTopics(){
	return topicPubSub;
  }

  @Override
  public GraphName getDefaultNodeName() {
    return GraphName.of("rosjava/getTopic");
  }

  @Override
  public void onStart(ConnectedNode connectedNode) {
    final Log log = connectedNode.getLog();
    //Client for the master roscore
    final MasterClient masterClient = new MasterClient(connectedNode.getMasterUri());


	
	connectedNode.executeCancellableLoop(new CancellableLoop() {
		Response<SystemState> systemState;
		Collection<TopicSystemState> topicSystemState;
		String out = "";
		@Override
		protected void setup() {
			
		}

		@Override
		protected void loop() throws InterruptedException {
			systemState = masterClient.getSystemState(getDefaultNodeName());
			topicSystemState = systemState.getResult().getTopics();
			//bit of code actually building the topic lists
			//TODO: skip if nothing changed?
			topicPubSub = new HashMap<String,List<Set<String>>>();
			for (TopicSystemState i : topicSystemState) {
				List<Set<String>> temp = new ArrayList<Set<String>>();
				temp.add(i.getPublishers());
				temp.add(i.getSubscribers());
				topicPubSub.put(i.getTopicName(),temp);
			}
			//pretty print the lists to the info log. Can/will comment out.
			String out = "";
			for (Map.Entry<String,List<Set<String>>> i : topicPubSub.entrySet()){
				out = out + "Topic: " + i.getKey() + "\n";
				List<Set<String>> temp = i.getValue();
				out = out + "Publishers: \n";
				for(String j : temp.get(0)){
					out = out + j + "\n";
				}
				out = out + "Subscribers: \n";
				for(String j : temp.get(1)){
					out = out + j + "\n";
				}
			}
			log.info(out);
			Thread.sleep(1000);
			}
	});
  }
}
