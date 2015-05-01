package org.tdd.reflection;

@MyClassAnnotation(name = "class", value = "Annotation")
public class ClassUseAnnotation {
	@MyMethodAnnotation(mark = "mark", runtime = false)
	public void sayHello() {

	}
}
