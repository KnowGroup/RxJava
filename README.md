# RxJava
Learn Reactive extension of JVM - RxJava

Know RxJava : Reactive Extensions for the JVM | Know Group Opensource Project

RxJava is a Java VM implementation of Reactive Extensions : a library for composing asynchronous and event-based programs by using observable sequences.It extends observer pattern to support sequences of data/events and adds operators that allows you to compose sequences together while abstracting away concerns about things like low-level threading synchronization, thread safety and concurrent data structures.
This Project uses Java 8 features to demonstrates usage of RxJava library. It covers following concepts like :
-	Reactive concept of High order functions ( Function that take function as parameters and returns function as parameter), Pure and Impure Functions, Function as parameter.
-	Creation of Observable using Observable.fromIterable, fromArray, fromFuture.
-	Usage of io.reactivex.disposables.Disposable & io.reactivex.schedulers.Schedulers
-	Demonstration of Subscribes to an ObservableSource and usage of callbacks to handle the items it emits and any error or completion notification it issues.
o	onNext : to accept emissions from the ObservableSource
o	onError : to accept any error notification from the ObservableSource
o	onComplete : to accept a completion notification 
-	Demonstrated Predicate based filtering over Observable builder Pattern like : Observable.fromIterable(bigIntegerList()).filter(n -> n.intValue() % 2 == 0).subscribe(c -> log.accept(c))
-	Demonstrated Postion filtering over Observable builder pattern by using Observable.firstElement(),lastElement(),take(n), takeLast(10), lastOrError(),defaultIfEmpty("default_value"), elementAt(nth Position), elementAtOrError(nth Position), distinct().
-	Sampling Operation that would restrict consumption time against emission time by using .timeout(3, TimeUnit.SECONDS) & .sample(1, TimeUnit.SECONDS) over Observable builder pattern.
-	Various Transformations like :
o	Buffer : Returns an Observable that emits buffers of items it collects from the source ObservableSource. The resulting ObservableSource emits connected, non-overlapping buffers, each of a fixed duration. E.g. Observable.buffer(1, TimeUnit.SECONDS) 1 second is given to collect event.
o	Group By : Groups the items emitted by an ObservableSource according to a specified criterion, and emits these grouped items as GroupedObservables.
o	One to Many : Returns an Observable that emits items based on applying a function that you supply to each item emitted by the sourceObservableSource, where that function returns an ObservableSource, and then merging those resulting ObservableSources and emitting the results of this merger. like Observable.flatMap(letter -> Observable.fromIterable(Arrays.asList(letter.toUpperCase(),letter.toLowerCase()))) 
o	One to One : Returns an Observable that applies a specified function to each item emitted by the source ObservableSource and emits the results of these function applications. Like Observable.map(letter -> letter.toUpperCase())
o	Scan : Returns an Observable that applies a specified accumulator function to the first item emitted by a source ObservableSource, then feeds the result of that function along with the second item emitted by the source ObservableSource into the same function, and so on until all items have been emitted by the source ObservableSource, emitting the result of each of these iterations. Like Observable.scan((letter1,letter2) -> letter1.concat(letter2)).lastElement()(to avoid intermediate events on subscribe we should use lastElement)
-	Demonstrate various Conditional Operators like Observable.skipWhile(Predicate), takeWhile(..),defaultIfEmpty(..),.takeUntil(..) which returns an Observable that emits the items emitted by the source Observable until a second ObservableSource emits an item.
-	ConnectableObservable which resembles an ordinary Observable, except that it does not begin emitting items when it is subscribed to, but only when its connect method is called. In this way you can wait for all intended Observers to Observable.subscribe to the Observable before the Observable begins emitting items.
-	Subject which represents an Observer and an Observable at the same time, allowing multicasting events from a single source to multiple child Observers.
o	AsyncSubject : A Subject that emits the very last value followed by a completion event or the received error to Observers.
o	BehaviorSubject : Subject that emits the most recent item it has observed and all subsequent observed items to each subscribed Observer.
