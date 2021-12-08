package br.com.example.jsftraining.flowbuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewRegistrationFlowBuilder implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newregistration";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/newregistration/newregistration.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newregistration/newregistration2.xhtml");
        flowBuilder.viewNode(flowId, "/newregistration/newregistration3.xhtml");
        flowBuilder.switchNode("newRegistrationPage2").defaultOutcome(flowId).switchCase()
                .condition("#{not empty testFlowBuilderBean.name and not empty testFlowBuilderBean.surname}")
                        .fromOutcome("newregistration2");

        flowBuilder.flowCallNode("callNewPendencies")
                        .flowReference("", "newpendencies")
                                .outboundParameter("username", "#{testFlowBuilderBean.name}")
                                .outboundParameter("userSurname", "#{testFlowBuilderBean.surname}");
        flowBuilder.returnNode("exitToInit").fromOutcome("/initflow.xhtml");
        flowBuilder.returnNode("exitToIndex").fromOutcome("/index.xhtml");
        flowBuilder.finalizer("#{testFlowBuilderBean.save}");
        return flowBuilder.getFlow();
    }
}
