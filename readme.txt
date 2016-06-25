1. Download and install JAX-WS Runtime for Tomcat

	1) Download the JAX-WS Runtime from https://jax-ws.dev.java.net. From the "Downloads" link, choose the latest version.
	2) Download the binary. Unpack the binary by double clicking the downloaded jar file (or run the JDK's jar tool).
	3) Copy all the jar files from the JAX-WS's "lib" directory to Tomcat's "lib" directory (i.e., "$CATALINA_HOME\lib").

    * jaxb-core.jar
	* jaxb-impl.jar
	* jaxws-api.jar
	* jaxws-rt.jar
	* gmbal-api-only.jar
	* management-api.jar
	* stax-ex.jar
	* streambuffer.jar
	* policy.jar
	* ha-api.jar

(上述Jar包注意要加入到tomcat的lib目录下，否则web service无法跑起来)
