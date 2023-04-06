# SpiGetLib
A (I hope) simple library for the ease of requesting from SpiGet :heart:
### Backstory
I needed a simpler way of getting some information from SpiGet. That's it.
# Getting started
## Creating a request
> All possible request are in the [requests folder](src/main/java/com/kolapsag/spiget/requests).
You can also call a custom request, if for example I wasn't able to update the repo, by doing
```SpigetRequest.customRequest(String url, String userAgent)```

To create a request, simply call: ```new <name of the request>(...)```
#### Example
```java
new ResourceSearchRequest("EssentialsX");

SpigetRequest.customRequest("/search/resources/EssentialsX", "Mozilla/5.0");
```
## Requesting and getting the response
To send a request from our object we do:
```java
new ResourceSearchRequest("EssentialsX").request();
```
The ```request()``` method sends the request and returns a [RequestResponse](src/main/java/com/kolapsag/spiget/request/response/RequestResponse.java) object
with which we can do:
```java
RequestResponse response = new ResourceSearchRequest("EssentialsX").request();

response.getResponse(); // Returns a JsonElement
response.getResponseArrayAsObject(); // This is useful if the request returns an array, but the size of it is only 1. Returns a JsonObject
```
## Request parameters
Some requests might allow you to add parameters to them, by that I don't mean constructor necessities. Take a look: [Resource Search](https://spiget.org/documentation/#!/search/get_search_resources_query)

So, there are two types of parameters: Unsafe and Type parameters

With Unsafe parameters you can just parse a string using the ```#setUnsafeParameters(String)``` method or if you would like more safety you can use the ```#setParameters(String)``` method, but be aware that this method might be costly

While Type parameters accept an enum ([RequestParameter](src/main/java/com/kolapsag/spiget/request/parameter/RequestParameter.java)) and a string value, which, of course, is checked beforehand.

Both methods aren't completely fool-proof, so just do whatever you feel right
> When building parameters (```RequestParameterHandler#buildParameters()```) Unsafe parameters are always prioritized if not empty
#### Example
```java
ResourceSearchRequest req= new ResourceSearchRequest("EssentialsX","field=name&size=1"); // Notice that we have a one-liner which is going to set Unsafe, unchecked, parameters, but is faster to type out

req.setParameter(RequestParameter.SIZE,"mac"); // Throws an error - size must be a number
req.setParameter(RequestParameter.SIZE,"5");

req.getRequestMethod(); // Prints /search/resources/EssentialsX?field=name&size=1

req.setParameters("ffewmklfw"); // Throws an error - invalid parameters
req.setUnsafeParameters("page=1&fields=sourceCodeLink,premium");

req.getRequestMethod(); // Now prints /search/resources/EssentialsX?page=1&fields=sourceCodeLink,premium
```