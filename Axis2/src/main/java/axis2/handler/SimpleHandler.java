package axis2.handler;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.HandlerDescription;
import org.apache.axis2.description.Parameter;
import org.apache.axis2.description.PhaseRule;
import org.apache.axis2.engine.Handler;

public class SimpleHandler implements Handler {

 /**
  * {@inheritDoc}
  */
 public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {
  System.out.println("Service Invoked : " + msgContext.getAxisService().getName());
  System.out.println("Operation Invoked : "
    + msgContext.getAxisOperation().getName().getLocalPart());
  System.out.println(msgContext.getEnvelope().toString());
  return InvocationResponse.SUSPEND;
 }

 /**
  * {@inheritDoc}
  */
 public HandlerDescription getHandlerDesc() {
  HandlerDescription handlerDesc = null;
  PhaseRule rule = null;

  rule = new PhaseRule("soapmonitorPhase");
  rule.setPhaseLast(true);

  handlerDesc = new HandlerDescription();
  handlerDesc.setHandler(this);
  handlerDesc.setName(this.getName());
  handlerDesc.setRules(rule);

  return handlerDesc;
 }

 /**
  * {@inheritDoc}
  */
 public String getName() {
  return "SimpleHandler";
 }

 /**
  * {@inheritDoc}
  */
 public void cleanup() {
 }

 /**
  * {@inheritDoc}
  */
 public void flowComplete(MessageContext msgContext) {
 }

 /**
  * {@inheritDoc}
  */
 public Parameter getParameter(String name) {
  return null;
 }

 /**
  * {@inheritDoc}
  */
 public void init(HandlerDescription handlerDesc) {
 }

}
