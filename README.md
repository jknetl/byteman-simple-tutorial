# Byteman simple tutorial

Byteman assignment with the tasks to practice its usage. You should try to finish the tasks by yourself. For those who don't know anything about byteman I would recommend going through Byteman's getting started tutorial. For complete information about byteman refer to the Byteman's programmers guide. Both resources may be found on [byteman's web page](http://byteman.jboss.org/docs.html).

The repository defines simple multithreaded application. There are multiple threads which increases a counter. The threads are arbitrarily interleaving while incrementing.  Your goal is to finish the tasks defined below __without modifying the app__. You are assumed to use just byteman. I will use BMUnit to solve the majority of the tasks (except the first one), but you may also use the provided Main and run standalone java application with byteman agent and load rules there.

## Task 1 (output information)

* create the rule that will inform user on standard output that counter thread is starting or stopping.
* then add rules which will output the information which thread has started the counter
  * this output statements should be easily turned on or off

These outputs from task 1 will be really helpful to verify that you have finished other tasks successfully.

## Task 2 (making a thread fail)

* make sure that thread which will increase counter to the 10 will fail (you thread should throw an exception)

## Task 3 (modify the counter rate)

* make sure that if thread increments counter than it increments it at least two times consecutively
  * in other words the thread is not allowed to increment just once and be interleaved with other thread

## Task 4 (synchronization)

* make sure that all threads will synchronize after increment.
  * for example if there are 4 threads, then each increment from 1,2,3,4 will be performed exactly by one thread (in arbitrary order). Then threads will synchronize themselves and there will be another round, where each thread will increment once and wait for the other threads and so on.
