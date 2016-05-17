# atg-utils
=======
Is a collection of utils to make using Oracle Commerce ATG easier to develop.
You can uses this as a pluggin module or just take the peices that you need and weave it into you own module

## BeanUtils
Can be used to safely get properties from a bean, map, repositoryItem
Example: 
```java
String merchantName = (String)BeanUtils.getNestedProperty(commerceItem,"auxiliaryData.catalogRef.merchant.merchantName"); 
String shippingMethod =(String)BeanUtils.getNestedProperty(merchantGroup,"commerceItems[0].shippingGroupRelationships[0].shippingGroup.shippingMethod"); 
```
This will not throw a NullPointerException in any of the elements in the graph even if they are null. This saves you from writing all the conditional statments to ensure that each element is not null in order to avoid NullPointerException

## ComparableComparator
Comparator to do in memory sorting.
It works with complex object using dot notation 
example 
Note when working with ATG List,Sets and Maps when they are retrieved form the repository then they are ChangeAware this means that if you sort then you change the order in the DB!!!!
  

```java
// To avoid checing the DB order disconnect the items form the List
List<RepositoryItem> result  = new ArrayList<RepositoryItem>();
result.addAll(dataToSort)
// now sort it 
ComparableComparator comparableComparator = new ComparableComparator("a.b.c");
Collections.sort(result, comparableComparator);
```
## ComponentResolver 
Used to resolve components, will first try Request scoped then Global
```java
Object myComponent = ComponentResolver.getComponent("/a/b/c/Component");
```

## InsertablePipelineServlet
An imporved vesion of the OOTB InsertableServletImpl it adds a simple toggle  ``` isEnabled() ``` to switch to enable or pass straigh to the next servlet.
It also fix wrapping of the request and response see the code for more detailed explanation 

## UserLocalePipelineServlet
An example of an InsertablePipelineServlet this is used to make a more efficent lookup of user profile locales, ATG default locale lookup is not very efficent and this get magnified if you are doing i18n tranlation and want to do it 1000 times in a page, that ensures that the locale is resolved and stored in a ThreadLocal variable make it much faster




## AbstractSchedulableService and AbstractSingletonSchedulableService
The way ATG services work is a bit strange, there not wired directly to components. These classed fix this simple extend the class you need AbstractSchedulableService will run on all servers AbstractSingletonSchedulableService will run on only one server in a cluster. 
It also adds a handy method for devlopment ```doScheduledTask()``` that can be invoked from the dyn/admin


```
$class=org.varelma.oc.MyService
$scope=global
loggingDebug=false
clientLockManager=/atg/dynamo/service/ClientLockManager
lockName=MyService
lockTimeOut=2000
scheduler=/atg/dynamo/service/Scheduler
schedule=every 1 minute in 1 minute
jobName=MyService
jobDescription=This service to do MyService
```


Additional ATG related 

For and implimantation of Java Generics in ATG see.

[https://github.com/varelma/atg-generics](https://github.com/varelma/atg-generics)

Also see the atgel project for a high performance expresion language implementation for ATG https://github.com/sparkred-insight/atgel

[https://github.com/sparkred-insight/atgel](https://github.com/sparkred-insight/atgel)

Feedback to jon@varelma.com

![Varelma](https://raw.githubusercontent.com/varelma/atg-generics/master/varelma-small.png "Varelma")








