package com.example;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class MyWorkItemHandler implements WorkItemHandler {
        private String param1;
        private String param2;

    public MyWorkItemHandler(String param1, String param2){
            this.param1 = param1;
            this.param2 = param2;
        }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        // sample parameters
        param1 = (String) workItem.getParameter("param1");
        param2 = (String) workItem.getParameter("param2");

        // complete workitem impl...
        String dummyCalculationLogic = param1 + " + " + param2;

        // return results
        String sampleResult = "sample result is: " + dummyCalculationLogic;
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("result", sampleResult);

        manager.completeWorkItem(workItem.getId(), results);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        // stub
    }
}


