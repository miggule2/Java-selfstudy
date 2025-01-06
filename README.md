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

## 3일차 - 예외
### 1. Error VS Exception
* __Error__ : 시스템이 종료되어야 할 상황같이 ```수습할 수 없는 심각한 문제```를 의미. 개발자가 미리 예측하여 방지할 수 없음.
* __Exception__ : ```개발자가 구현한 로직에서 발생한 실수, 혹은 사용자의 영향에 의해 발생```. 개발자가 미리 예측하여 방지하는 __예외 처리(Exception Handle)__ 를 해야함.

### 2. 예외가 발생하는 이유
* __개발자가 설계한 대로(실수, 사용자의 영향) 실행되지 않았기 때문.__
```java
public class ExceptionApp {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2/0);
		System.out.println(3); 
	}
}
```
* 자바는 숫자를 0으로 나누는 경우를 예외로 지정.
* 예외가 발생한 지점으로부터 그 뒤의 코드는 실행되지 않음.

### 3. 예외 처리
* 숫자를 입력받아 계산하는 코드의 경우 사용자가 0을 입력하면 예외가 발생하는 불안정한 코드.
* ```try catch 문```을 이용해서 ```예외 처리```
```java
public class ExceptionHandelApp {
    public static void main(String[] args) {
        System.out.println(1);
        try{
            System.out.println(2/0); // Run-Time Exception -> ArithmeticException
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }
        System.out.println(3);
    }
}
```
```
실행결과

1
Arithmetic Exception
3
```
* 이런 식으로 코드를 수정해주면 예외가 발생할 경우 처리 가능.
<hr>

* 좀 더 복잡한 예외 상황을 가정해보자.
```java
public class ExceptionApp2 {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10, 20, 30};
        System.out.println(2);
        System.out.println(scores[3]); //ArrayIndexOutOfBoundsException
        System.out.println(3);
        System.out.println(2/0); //ArithmeticException
        System.out.println(4);
        System.out.println(5);
    }
}
```
* 이 경우 ArrayIndexOutOfBoundsException, ArithmeticException 동시에 발생할 수 있음.
* 이 경우에는 어떻게 처리해야 할까?
```java
public class ExceptionHandelApp2 {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10, 20, 30};
        try{
            System.out.println(2);
            System.out.println(scores[3]); //ArrayIndexOutOfBoundsException
            //여기까지 실행 후, catch (Exception e)문으로 이동.
            System.out.println(3);
            System.out.println(2/0); //ArithmeticException
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception");
        }
        System.out.println(5);
    }
}
```
* ```ArrayIndexOutOfBoundsException```의 경우 ```catch (ArrayIndexOutOfBoundsException e)```문을 실행 후 try문 실행을 멈추고 다음 코드를 실행.
* ```ArithmeticException```의 경우 ```catch (ArithmeticException e)```문을 실행 후 try문 실행을 멈추고 다음 코드를 실행.

### 4. 예외 처리의 우선 순위
* 예외도 클래스(상속)으로 구현되어 있음.

<img src="https://flylib.com/books/2/254/1/html/2/images/13fig03.jpg">

* 위의 그림에 따라 ```ArithmeticException```은 ```RuntimeException```을 상속받고,
* ```RuntimeException```은 ```Exception```을 상속받는다.
* 이를 활용하여 예외의 처리도 포괄적으로 처리할 수 있다.
```java
public class ExceptionHandleApp3 {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10, 20, 30};
        try{
            System.out.println(2);
            System.out.println(scores[3]); //ArrayIndexOutOfBoundsException
            System.out.println(3);
            System.out.println(2/0); //ArithmeticException
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(5);
    }
}
```
* 이 경우 ```ArrayIndexOutOfBoundsException```이 발생하면 해당 예외는 ```Exception```이 포괄적으로 포함하고 있기에, ```catch (Exception e)```에서 처리 가능.
* ```ArithmeticException```이 발생하면 catch구문을 위에서 부터 내려가며 처음 걸리는 ```catch (ArithmeticException e)```에서 처리.

### 5. 변수 e의 역할
* ```catch의 변수 e```는 예외가 발생한 ```원인, 발생한 지점 등```과 같은 정보들이 포함.
```java
public class ExceptionHandleApp2 {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10, 20, 30};
        try {
            System.out.println(2);
            System.out.println(3);
            System.out.println(2 / 0); //ArithmeticException
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(5);
    }
}
```
```
실행결과

1
2
3
ArithmeticException/ by zero
5
java.lang.ArithmeticException: / by zero
	at day3_exception.exception.ExceptionHandleApp2.main(ExceptionHandleApp2.java:10)
```
* ``` e.getMessage()```를 통해```/ by zero``` 다음과 같이 예외의 디테일한 문자열을 받을 수도 있고
* ```e.printStackTrace();```를 통해 ```java.lang.ArithmeticException: / by zero
  at day3_exception.exception.ExceptionHandleApp2.main(ExceptionHandleApp2.java:10)``` 와 같은 에러 메세지도 출력할 수 있음.

### 6. checked Exception VS unchecked Exception
* 위의 예제와 같은 코드를 작성했을 때, 컴파일 되어 실행은 가능했다. 이러한 예외를 ```unchecked Exception```이라고 한다.
* ```unchecked Exception```은 ```Runtime Exception```을 상속받은 예외들이다.
* 반대로 예외 처리(try catch 등)과 같은 처리를 하지 않으면 컴파일 자체가 안되는 예외가 있는데, 이를 ```checked Exception```이라고 한다.
* ```checked Exception```은 ```Runtime Exception```을 제외한 모든 에러와 예외들이다.
```java
public class CheckedException {
    public static void main(String[] args) {
        try{
            FileWriter f = new FileWriter("data.txt");
            f.write("hello");
            f.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
```
* 위의 코드는 IOException(checked Exception)을 발생시키기 때문에, 예외처리를 반드시 해야 컴파일을 할 수 있다.

### 7. Resource와 finally문
* __resource(자원)__ : 프로그램 외부에 존재하는 접근해서 작업해야 하는 데이터들(파일, 네트워크, DB 등)
* 자원을 사용하기 위해선 자원을 붙들고 있어야 하고, 작업을 마무리 할 땐 붙들고 있는 자원을 놓아줘야 한다.
* ```f.close()```가 위의 역할을 한다.
* 하지만 6번의 예제코드처럼 작성하면 자원에 접근하여 처리하던 도중 문제가 발생하면 ```f.close()``` 가 수행되지 않고, 넘어가버리는 문제가 발생한다.
* 이를 처리하기 위해 ```finally문```이 사용된다.
```java
public class Finally {
    public static void main(String[] args) {
        FileWriter f = null;
        try{
            f = new FileWriter("data.txt");
            f.write("hello");
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(f != null){
                try{
                    f.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```
* 다음과 같이 작성하여, 자원에 접근 도중 문제가 발생하여도 자원을 놓아주는 코드를 작성할 수 있다.

### 8. Try with Resource
* 위의 코드는 아주 복잡한 코드 진행같아 보인다.
* 그래서 Java SE 7부터 ```try-with-resource```를 지원한다.
* 이는 사용하고자 하는 클래스(FileWriter)가 ```AutoClosable 인터페이스```를 상속한다면 사용할 수 있다.
```java
public class TryWithResource {
    public static void main(String[] args) {
        try(FileWriter f = new FileWriter("data.txt")){
            f.write("hello");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
```
* try 문 괄호 안에 사용할 자원을 정의.
* 세미콜론으로 구분하여 객체를 여러개 생성할 수도 있음.
* 자동으로 자원을 닫아주기 때문에, __f.close()__ 와 같이 명시적으로 자원을 놓아줄 필요 없음.

### 9. throw와 throws
* ```throw Exception```을 사용하면 우리의 코드에서 직접 예외를 발생시킬 수 있다.
```java
public class Throw {
    public static void main(String[] args) {
        throw new RuntimeException("문제가 발생했음!"); // 여기서 예외 발생
    }
}
```
* 이런 식으로 우리의 코드에서 무조건적으로 예외를 발생시킬 수 있음.

* ```throws```를 이용하면 ```try catch```처럼 직접 예외를 처리하지 않고, 발생한 예외를 누군가 처리해달라고 던질 수 있다.
```java
public class Throws {
    public static void main(String[] args) throws IOException{
        FileWriter f = new FileWriter("data.txt");
        f.write("hello");
        f.close();
    }
}
```
* 우리가 작성한 메소드에서 예외가 발생한 경우 ```throws```이용해서 예외 처리 다른 누군가에게 던질 수 있다.

### 3일차 공부에서 느낀점/배운점
* 알고리즘 문제 풀면서 IOException과 같은 예외를 본 적은 있어도, 정확한 정의나 어떤식으로 사용되는지 조금은 알 수 있었다.
* 미니 프로젝트(키오스크 만들기)에서 따로 메서드를 만들어서 if-else문으로 직접 문제가 된 부분을 처리했는데,
* 오늘 배운 예외, 예외처리로 조금 더 깔끔하게 문제를 처리할 수 있겠다고 생각했다.

## 4일차 - 시간 복잡도
### 1. 시간복잡도란?
* __프로그램의 입력값에 따른 연산 수행 시간의 상관관계를 나타낸 척도__

### 2. 시간복잡도의 규칙
1. __입력값은 항상 0보다 크다.__
2. __더 많은 입력값__ 에 따라 함수는 __더 많은 작업__ 을 해야 한다.
3. 시간 복잡도에서 __상수는 무시__ 한다.
    * 어떤 알고리즘의 복잡도가 ```5n```이라면 이는 복잡도 ```n```이 된다. 
4. __낮은 항의 차수는 무시__ 한다.
    * 알고리즘의 복잡도를 생각할 때는 __n이 무한대로 가는 경우__ 를 가정한다.
    * 따라서 복잡도를 계산하는 경우엔 낮은 차수의 항들은 무시한다.
    * 예를 들어 n^3 + n^2 + n 함수는 복잡도 n^3로 생각해주면 된다.
5. 시간 복잡도의 함수가 __log 함수__ 를 포함한 경우, __밑은 무시__ 한다.
    * 복잡도가 log인 알고리즘은 주로 무언가를 ```반으로 나누거나```, ```2를 곱하는 경우```사용한다.
    * 시간 복잡도를 비교할 경우에 ```밑은 계산하기 쉬운 숫자```아무거나 넣어서 계산해도 된다.
6. __등호를 사용하여 표현__ 한다.
    * ```2n``` 은 ```O(n)```과 같다.
    * 이는 ```O(n)```에 2n이 포함된다는 의미로 사용된다.
    * 즉, ```등호```는 집합의 ```원소를 포함한다```의 기호로 사용된다.

### 3. 빅 오 표기법
* __정의__ : __알고리즘의 효율성을 표시하는 표기법__ .
* 이를 사용해서 다른 알고리즘과 비교가 가능하다.
  <img src="https://cphinf.pstatic.net/mooc/20210525_284/1621921589246JLuBn_PNG/mceclip0.png">
* 위의 그래프는 ```복잡도가 n```인 알고리즘을 기준으로 빅 오 표기법을 적용한 그래프이다.
* ```다른 알고리즘의 그래프가 어떤 위치에 있냐에 따라``` 복잡도 n인 알고리즘과 비교할 수 있다.
* 복잡도 n의 그래프보다 위에 있으면, 입력값에 따른 수행 시간이 더 많이 걸리기에 ```더 느린 알고리즘```이고,
* 복잡도 n의 그래프보다 아래에 있으면, 입력값에 따른 수행 시간이 더 덜 걸리기에 ```더 빠른 알고리즘```이다.
* 빅 오 표기법에서 이러한 알고리즘의 관계를 다음과 같이 정의.
    * O(빅 오 복잡도) : 비교 대상인 그래프가 일치 혹은 아래에 있을 때, 비교 대상인 알고리즘과 ```같거나 더 빠르다``` (```부등호 >=```)
    * o(리틀 오 복잡도) : 비교 대상인 그래프가 아래에 있을 때, 비교 대상인 알고리즘보다 ```더 빠르다``` (```부등호 >```)
    * θ(빅 오 복잡도) : 비교 대상인 그래프가 일치할 때, 비교 대상인 알고리즘과 ```동일하다.``` (```부등호 =```)
    * Ω(빅 오메가 복잡도) : 비교 대상인 그래프가 일치 혹은 위에 있을 때, 비교 대상인 알고리즘과 ```같거나 더 느리다``` (```부등호 <=```)
    * ω(리틀 오메가 복잡도) : 비교 대상인 그래프가 위에 있을 때, 비교 대상인 알고리즘보다 ```더 느리다``` (```부등호 <```)

### 4. 빅 오 표기법의 예시
* n<sup>3/4 = O(nlogn) ? -> F
  * 그래프를 그려보면 가장 정확하겠지만,
  * 그보다 ```n에 충분히 큰 수를 대입해서 점 두 개를 각각 원점과 이어 그 그래프를 비교```하면 보다 간단히 해결할 수 있다. 
  * ```n에 1000을 대입```하면 10000 > 3000을 만족한다.(로그 계산시 계산하기 편한 수를 대입하여 계산하면 된다)
  
  <img src="https://cphinf.pstatic.net/mooc/20210525_250/1621922217702RNvY9_PNG/mceclip0.png">

* 3n<sup>3 + 4n<sup>2 + 5n + 6 =  θ(n^3) ? -> T
  * 위는 앞서 설명한 ```낮은 차수는 무시한다.```와 ```상수는 무시한다.```는 규칙을 적용하면
  * n<sup>3 = θ(n^3) 과 동일하고, 이는 참이다.

* 2<sup>n = w(n) ? -> T
    * 앞서 설명한 것처리 충분히 큰 수 ```1000을 대입```하면
    * 2<sup>1000 > 1000 을 만족하기에 위의 식은 참이 된다.

### 4일차 공부에서 느낀점/배운점
* 시간 복잡도에서 아주 대략적인 개념만 알고 있었는데, 이번을 기회로 빅 오 표기법에 대한 자세한 정의와 사용을 알 수 있어서 아주 의미있는 시간이었다.
* 추천받아서 처음 들어본 강의였는데, 처음부터 차근차근 설명해줘서 이해하기 쉬웠다.

#### 4일차 출처 : <https://www.boostcourse.org/cs204/joinLectures/145114>