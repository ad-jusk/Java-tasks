all: Server.class

Server.class: Server.java Client.java ClientRunnable.java WrongInputException.java ListenerRunnable.java MessageHandler.java
	javac $^
clean:
	rm ./*.class