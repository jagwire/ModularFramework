ModularFramework
================
A framework for decoupling classes for testability, readability, and maintainability.

Annotations
-----------

@CompositionRoot

* There should only ever be one of these...ever
* This is the entry point of the program

The composition root's bigggest job is to provide a clear indication of where a program built with this framework starts. One should only ever have to "find usages" of CompositionRoot from an IDE and see a single class appear. It's advised your project have a "core" module, and by convention, place your composition root here.

Why name it composition root?
Conventionally, a good development practice is to create all objects you might need at the start of your application. This start "container", if you wil, is the composition root.

@Injectable

Classes marked as "injectable" are for sub-frameworks where a Singleton pattern is typically found. Since singletons are often hard to test, we annotate them as injectable and access them as such. The ModularFramework will only instantiate these once.


@AbstractFactory(interfaceType, distinguisherType)

As previously mentioned, by convention, all necessary objects should be created on application start. You might be asking yourself "but what if I need new objects?". Well...in the event that you need new objects, you plan ahead and write factory classes to allow these objects to be made at runtime. Annotating these as factories allows the AbstractFactory implementation to find your factory and create it for you...in order for your to use this factory to create your new object at runtime.

@Inject

Inject is used to mark fields within classes to be populated with the Injectable object of the same type. If there is no injectable object, it will be set to null. Building off the injectable pattern, this allows us to remove lines such as BigManagerClass.INSTANCE.getContextField() to instead, just access a variable of type BigManagerClass.


@Strategy(interfaceType)

While testing-driving applications, we should always always always program to the interface and not the dependency. Using this paradigm, any dependency should be marked as a 
Strategy. Instead of injecting these through a method or constructor, we can automatically have access to them. 

Example:

    IBoxObject box = strategies.get(IBoxObject.class);
    box.addItemsToMe("fork", "knife", "spoon");


		


Classes
----------
* Framework
* InjectionFriendlyObject (IFO)

An IFO is an abstract base class to provide access to the framework proper as well as automatically inject any injectables needed into the class.

Convenience methods include:


strategies() -- hook into Framework class to get any strategy-marked classes (typically interface implementations)

getNew(interface.class, distinguisher.class, distinguisher) -- shorthand for invoking a factory to create a new object

isA(.class) -- alias for -- instanceof

isAn(.class) -- alias for -- isA(.class)

is(object) -- alias for -- equals()

log("msg ") -- decorator for -- Logger.getLogger(getClass().getName()).warning(message);

getPropertyByName(key) -- allows access to any user defined properties using a HashMap

setProperty(key, value) -- allows for creation and update of any user defined properties using a hashmap

