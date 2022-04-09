all: Server.class

Server.class: Server.java Client.java ClientThread.java WrongInputException.java
	javac $^
clean:
	rm ./*.class