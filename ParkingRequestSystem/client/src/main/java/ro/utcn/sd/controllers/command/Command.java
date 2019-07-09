package ro.utcn.sd.controllers.command;

public interface Command<T> {

	   T execute();

	   T undo();
}
