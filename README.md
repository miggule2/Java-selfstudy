# Java 독학

## 1일차 - 상속
<hr>

### 1.상속의 정의  
* 상속(Inheritance)는 객체 지향 프로그래밍에서 한 클래스가 다른 클래스의 속성과 메서드를 물려 받는 기능.
* 이를 통해 코드의 재사용성을 높이고, 클래스 간의 관계를 명확히 할 수 있다.

### 2. 기본 개념
* ```부모클래스(SuperClass)``` : 다른 클래스에게 속성과 메서드를 물려주는 클래스.
* ```자식클래스(SubClass)``` : 부모 클래스의 속성과 메서드를 상속받는 클래스.
* ```오버라이딩``` : 자식 클래스가 부모 클래스의 메서드를 재정의 하는 것.

### 3. 상속을 안 받았을 경우 vs 받았을 경우 -> 상속의 장점
* ```상속을 안 받았을 경우```
```java
public class Dog {
    String name;
    int age;
    
    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void makeSound(){
        System.out.println("Woof!");
    }
}

public class Cat {
    String name;
    int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("Meow!");
    }
}

public class NoInheritanceMain {
    public static void main(String[] args) {
        Dog dog = new Dog("doggy", 2);
        Cat cat = new Cat("catgy", 3);

        dog.makeSound();
        cat.makeSound();
    }
}
```
* __문제점__
1. __코드중복__: Dog와 Cat 클래스에서 name, age 속성을 각각 정의해야 하는 코드 중복 발생.
2. __유지보수 측면__: 예를 들어 속성을 하나더 추가 하고 싶으면, 모든 객체 클래스에 속성을 각각 추가해야 한다.

* ```상속을 받았을 경우```
```java
public class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("animal sound");
    }
}

public class Dog extends Animal {
    Dog(String name,int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("meow!");
    }
}

public class InheritanceMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 2);
        Cat cat = new Cat("bully",3);

        dog.makeSound();
        cat.makeSound();
    }
}
```
* __문제해결 (상속의 장점)__
1. __코드 재사용__ : 앞서 코드 중복과는 다르게 Animal 클래스에만 속성을 추가하면 상속 받는 클래스에서는 코드를 중복할 필요가 없다.
2. __유지 보수의 용이성__ : 새로운 속성이 필요한 경우 Animal 클래스에만 추가해주면 된다.
3. __확장의 용이성__ : 새로운 동물을 추가하고 싶다면, Animal 클래스를 상속 받기만 하면 쉽게 확장할 수 있다.

### 4. 상속의 종류
* 단일 상속: 한 클래스가 하나의 부모 클래스를 상속받는 상속 형태. 자바는 ```단일 상속```만을 지원한다.
* 다중 상속: 자바는 다중 상속을 지원하지 않지만, ```인터페이스```에서 유사한 기능 구현 가능.

### 5. 오버라이딩
* 정의: 자식 클래스에서 부모 클래스의 메서드를 재정의하는 것.(3번 ```makeSound 메서드``` 참고)
* 오버라이딩 규칙 : 
  1. 메서드 이름, 리턴 타입, 매개변수 모두 부모 클래스와 동일해야함.
  2. ```@Override```애너테이션을 사용하면 컴파일러에게 의도를 명확히 전달하고, 오류도 방지할 수 있다.

### 6. 상속시 자바 메모리 공간의 작용
* __자식 객체 생성__ : Dog 객체 생성시 ```heap 메모리```에 Dog 객체 생성.
```java
[Stack Memory]
--------------------------------
| Method Call: main           |
|  - Local Variable: myDog    | ---> [Heap Memory]
|                              |      | Dog Object                  |
|                              |      |  - name (inherited)         |
|                              |      |  - makeSound() (overridden) |
--------------------------------
```
* __부모 객체의 생성__ : Dog 객체 생성시 Animal 속성과 메서드도 Dog 객체 내에 포함.
* __클래스 정보__ : Animal,Cat,Dog 와 같은 클래스에 대한 정보는 자바의 ```Method 영역```에 저장된다.
```java
[Method Area]
--------------------------------
| Class: Dog                  | ---> [Heap Memory]
|  - Method: makeSound()      |      | Dog Object                  |
|                             |      |  - name (inherited)         |
--------------------------------

```

### 7. 예제
* 3번 문제의 상속받은 코드에서 Bird 클래스를 추가해라.
* ___정답코드___
```java
public class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Chirp!");
    }
}

public class InheritanceMain {
  public static void main(String[] args) {
    Dog dog = new Dog("Buddy", 2);
    Cat cat = new Cat("bully",3);
    Bird bird = new Bird("bird", 1);

    dog.makeSound();
    cat.makeSound();
    bird.makeSound();
  }
}
```
* 오늘 배운 내용을 바탕으로 Animal을 상속받는 Bird 클래스를 만들어 makeSound()까지 구현.

### 1일차 공부에서 느낀점
* 이미 배운 내용에 대한 복습이라 다소 간단히 느껴진 부분이 있었다.
* 하지만 기본적인 부분에 대해서 자세하게 잡고 가야 뒤에서 무너지는 부분이 없을 거라 생각하고 성실히 공부할 예정.
* 자바 강의를 들으며 배운 것인데, ```자바 메모리```와 연관지어 해당 코드를 시행했을 경우 어떤 메모리 공간에서의 작용이 일어나는지 이미지화 시켜보는 것이 많은 도움이 되었다
* 다른 자바 개념을 배울 때도 이미지화 시켜 무슨 일이 일어나는지 알고 배우는 것은 그냥 배우는 것과는 차이가 있을 거라 생각한다.