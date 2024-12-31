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

## 2일차 - 다형성(1) (Polymorphism)
<hr>

### 1. 다형성의 정의
* __다형성__ 은 해석하자면 "여러 형태를 가질 수 있는 능력"을 의미함.
* 객체 지향 프로그램에서 다향성은 동일한 부모 클래스나 인터페이스를 통해 다양한 객체를 다룰 수 있게 해주는 특성.

### 2. 다형성의 종류
1. __컴파일 타임 다형성(Static Polymorphism)__
* __메서드 오버로딩__ : 같은 이름의 메서드가 매개변수의 타입이나 개수에 따르게 다르게 행동하는 것을 의미. 이 경우 컴파일 타임에 어떤 메서드가 호출될지 결정.

2. __런타임 다형성(Dynamic Polymorphism)__
* __메서드 오버라이딩__ : 부모 클래스에서 정의된 메서드를 자식 클래스에서 재정의하여, ```객체의 실제 타입```에 따라 호출되는 메서드가 달라지는 것을 의미. 이 경우 ```실행시점```에 어떤 메서드가 실행될지 결정.

### 3. 다형성 사용X VS 다형성 사용
* __다형성을 사용하지 않은 경우__
```java
// Dog 클래스
class Dog {
  void makeSound() {
    System.out.println("Woof!");
  }
}

// Cat 클래스
class Cat {
  void makeSound() {
    System.out.println("Meow!");
  }
}

// 메인 클래스
public class Main {
  public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();

    dog.makeSound(); // Woof!
    cat.makeSound(); // Meow!
  }
}

```
* 다형성을 사용하지 않아서 별도의 클래스를 호출해야 하며, 코드가 중복되고 유연성이 부족.

* __다형성을 사용한 경우__
```java
// Animal 인터페이스
interface Animal {
    void makeSound(); // 소리를 내는 메서드
}

// Dog 클래스
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Cat 클래스
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Animal 타입의 참조변수로 Dog 객체 생성
        Animal myCat = new Cat(); // Animal 타입의 참조변수로 Cat 객체 생성

        myDog.makeSound(); // Woof!
        myCat.makeSound(); // Meow!
    }
}

```
* __비교__
  1. 코드 중복 : 
     * __다형성을 사용하지 않은 경우__ 에는 각각의 클래스에서 makeSound() 메서드 정의. 이로 인해 코드가 중복.
     * __다형성을 사용한 경우__ 에는 모든 동물 클래스가 Animal 인터페이스를 구형하도록 함. 이렇게 하면 코드를 추가할 때도 단순히 인터페이스만 사용하여 처리 가능.
  2. 유연성 :
      * __다형성을 사용하지 않은 경우__ 에는 각 동물의 소리를 출력하기 위해 메인 클래스에서 각각의 객체를 생성.
      * __다형성을 사용한 경우__ 에는 ```Animal타입의 참조 타입 변수``` 다양한 동물 객체를 동일한 방식으로 처리 가능.
  3. 확장성 :
      * __다형성을 사용하지 않은 경우__ 에는 새로운 동물 클래스를 추가할 때마다 완전히 새로운 코드 작성.
      * __다형성을 사용한 경우__ 에는 해당 클래스에서 Animal 인터페이스를 구현하기만 하면 됨.

### 4. 다형성의 장점
1. __코드의 유연성__
* 동일한 인터페이스를 사용해서 서로 다른 객체더라도 동일한 메서드 호출로 처리 가능. 3번의 예제 코드에서 모든 동물의 makeSound()를 호출하고 싶다면, 모든 객체를 생성하는 것이 아닌, Animal 타입의 배열을 만들어서 한 번에 처리가 가능.
2. __기존 코드의 활용__
* 부모 클래스에서 사용된 메서드를 자식 클래스에서 ```오버라이딩```하여 새로운 기능 구현.
* __상속과 결합__ : 다형성은 상속과 함께 사용되어 상속의 장점을 그대로 활용할 수 있음.
3. __유지보수에 용이__ 
* __변경의 최소화__ : 코드의 특정 부분을 수정할 경우, 객체의 실제 타입에 따라 적절한 메서드가 자동으로 호출되므로, 수정의 범위를 줄일 수 있음.
4. __런타임 결정을 통한 유연성__
* __실행 시점의 결정__ : 사용자 입력에 따라 다른 객체가 생성되도록 할 수 있음.

### 5. 번외 - 인터페이스
* __정의__ : 인터페이스는 클래스가 구현해야하는 메서드 집합을 정의하는 일종의 계약.

* __특성__
1. __구현 강제__ : 인터페이스에서 정의된 메서드는 이를 구현하는 클래스에서 반드시 정의.
2. __다중 상속__ : 자바 클래스에선 지원하지 않는 다중 상속 지원.
3. __상수 정의__ : 기본적으로 인터페이스의 필드는 상수로 정의.
4. __메서드 접근 제어자__ : 인터페이스 내 메서드는 기본적으로 ```public```이며, 명시할 필요 없음.
* __목적__
1. __다형성 제공__ : 인터페이스를 통해 서로 다른 클래스가 동일한 메서드를 구현 가능케 함.

### 6. 예제
* 3번 예제에서 Bird 클래스를 생성하고, Animal 참조 타입 배열을 활용해서 동물 울음 소리를 출력하세요.
* 정답코드
```java
public class Bird implements Animal{
    @Override
    public void makeSound() {
        System.out.println("peow~");
    }
}

public class Main {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Dog();
    animals[1] = new Cat();
    animals[2] = new Bird();
    for (Animal animal : animals) {
      animal.makeSound();
    }
  }
}
```
* Animal 참조 타입 배열을 생성하여, 서로 다른 동물 객체를 하나로 묶어 기능하게 함.

### 2일차 공부에서 느낀점/배운점
* 오버로딩이 뭔지는 알고 있었지만, 이 또한 다형성의 개념에 들어가는줄 처음 알게 되어, 조금은 신기했음.
* 오늘 배운 내용들을 큰 틀에서는 알고 있었지만, 조금 더 디테일하게 다형성을 사용한 경우, 아닌 경우를 비교하며 어떤 부분에서 이점을 가지는지 더욱 자세하게 알 수 있었음.
* 배운 내용들을 장황하게 적는 것보다 조금 더 컴팩트하게 적는 연습을 해야겠다고 생각.
* __다형성의 핵심!!! -> 서로 다른 객체들을 한 번에 묶어서 활용할 수 있다!__