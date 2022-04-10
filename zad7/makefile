all: Server.class

Server.class: Server.java Client.java ClientRunnable.java WrongInputException.java ListenerRunnable.java
	javac $^
clean:
	rm ./*.class