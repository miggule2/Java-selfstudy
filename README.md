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

## 5일차 - 자료구조를 위한 준비(제네릭 프로그래밍)
### 1. Comparable 인터페이스
* 만약 우리가 어떤 문자열 두개를 비교하고 싶다면 어떻게 하는가?
### __override__
```java
public class Equals1 {
    public static void main(String[] args) {
        String one = "hello world!";
        String two = "hello world!";
        if(one.equals(two)){
            System.out.println("they are the same");
        }
    }
}
```
* 그럼 ```equals()```은 어디서 온 것일까?
* ```Object 클래스```에서 온 것일까요? 
* 만약 override 되어 있지 않다면
```java
    public static void main(String[] args) {
    Object one = "hello world!";
    Object two = "hello world!";
    // 오버라이딩 되어 있지 않다고 가정.
    if(one.equals(two)){
        System.out.println("they are the same");
    } else{
        System.out.println("they are not the same");
    }
}
```
* 결과는 서로 같지 않다는 결과를 얻을 것이다. (Object의 equals는 메모리 주소를 비교)
* ```Object 클래스```의 ```equals```를 사용하면 둘의 참조값이 같은지를 비교하기 때문이다.
* 우리가 만든 클래스(예를 들어 ```Student```)간의 비교를 위해선 ```equals```를 ```override```해야한다. (우리가 만든 클래스는 모두 java의 ```Object```의 상속을 받음.)

### __Comparable 클래스__
* 우리는 두 개를 비교할 때, 같다는 것보다 작거나 큰 경우를 더 많이 필요로 한다.
```java
//Comparable<T> interface
public int compareTo(T obj){
    // a.compareTo(b);
    if(a<b) return -1; // <0인 무언가
    if(a==b) return 0;
    if(a>b) return 1; // >0인 무언가
}
```
```java
if (((Comparable<T>)data).compareTo(obj)==0);
```
* 위와 같이 Comparable 인터페이스를 만들면 자료형에 알맞은 데이터가 들어와서 compareTo 함수를 통해 같은 자료형의 데이터를 비교할 수 있음.
```java
public boolean contains(E obj); // 연결리스트의 메서드
```
* 위의 코드를 활용하여 연결리스트의 contains 메서드를 구현할 수 있음.

### 2. 제네릭 프로그래밍 
* 여기 정렬 알고리즘을 만들었다고 가정해보자.
```java 
public class ss{
    public int[] superSort(int[] array){
        /// sort
        reutnr array;
    }
}
```
* 이를 문자열에도 사용하고 싶으면 어떻게 할까요?
* 문자열에 대해서도 다시 메서드를 만들어주면 됩니다.
* 하지만 그렇게 하면 모든 객체 타입마다의 메서드를 만들어 줘야 하기 때문에 아주 비효율적입니다.
* __그 문제를 해결하기 위해 우리는 ```제네릭 프로그래밍```을 합니다.__
  * ```제네릭 프로그래밍의 목적```은 1가지 코드만 작성해서 이를 다른 자료형에서도 사용할 수 있도록 하는 것!

### 3. Parameterized Types (매개변수화 타입)
* 제네릭 프로그래밍을 구현하기 위한 방법으로 ```매개변수화 타입```을 사용할 수 있다. ```<>```안에 ```Type Parameter```를 넣어 컴파일 시에 구체적인 타입이 결정되도록 하는 것.

```java
// 클래스
public class LinkedList
public class LinkedLilst<E>

// 함수
public void addFirst(String S)
public void addFirst(E obj)

public String removeFirst()
public E removeFirst()
```
* 다음과 같이 매개변수화 타입을 사용하기 위해선 아래와 같이 고쳐줘야 한다. 다만, 생성자의 경우 예외적으로 E를 사용하지 않는다.

```java
public class Node<E> {
    E data;
    Node<E> next;
    public Node(E obj) {
        data = obj;
        next = null;
    }
}
```
* 다음은 매개변수화 타입을 이용해서 어떠한 자료형이든 담을 수 있는 제네릭 노드를 만드는 코드.

### 5일차 공부를 하면서 느낀점/배운점
* 제네릭 프로그래밍을 거의 처음 배우는 거라 조금은 어렵게 느껴졌다.
* 본 강의에서는 자료구조를 배우기 위한 아주 기초적인 개념들만 짚고 넘어가니, 제네릭 프로그래밍에 대한 깊이있는 이해를 하기엔 부족했다.
* 일단 자료구조 강의를 먼저 수강한 뒤, 제네릭 프로그래밍에 대해 공부를 더 하고 넘어가야할지 판단해야겠다.

## 6일차 - 연결리스트
### 1. 연결리스트 정의
<img src="https://miro.medium.com/v2/resize:fit:1080/0*chiZd2LxZXoXWL52.jpg">

출처: https://harsh05.medium.com/linked-lists-data-structure-in-c-ef52fcee0e09 
* __포인터를 이용해 여러개 노드를 연결하는 자료구조__

    ### 배열과의 차이점 
    * 배열은 ```크기와 요소의 개수의 차이로 인한 불필요한 메모리 낭비```가 발생할 수 있는 반면
    * 연결리스트는 ```항상 맞는 크기로 만들어지도록 설계```

    ### 노드와 크기
  ```java
    public class LinkedList<E> { //implements List<E>
    // 노드 정의
    class Node<E> {
    E data;
    Node<E> next;
    
            public Node(E data) {
                this.data = data;
                next = null;
            }
        }
    
        private Node<E> head;
        // 노드 개수 세는 변수
        private int currentSize;
        // 기본 연결 리스트
        public LinkedList(){
            head = null;
            currentSize = 0;
        }
        // ...
    }
  ```
    * 위 코드는 __연결리스트 내부 클래스에서 노드를 정의__ 하고, __연결리스트의 필드를 정의__ 한 내용.
    * 노드에는 ```다음 노드를 가리키는 포인터 변수 next```와 ```data```를 가진다.
    * 노드는 내부 클래스로 정의되어, 연결리스트가 아닌 외부에서 접근하지 못 하도록 정의.
    * ```head```와 ```currentSize``` 또한 private으로 정의되어 외부에서 접근하지 못 하도록 정의.
  
    ### 연결리스트에서 노드의 개수를 효율적으로 세기 위한 방법
    * 노드의 개수를 직접 세는 방법(```θ(n)```)이 아닌, __```currentSize```변수를 만들어 노드의 개수를 센다.(```θ(1)```)___
    
### 2. 자료구조의 경계 조건
* 자료구조에서 아래의 경계 조건에서 문제가 생기진 않는지 확인 필요.
  1. 자료 구조가 비어있는 경우
  2. 자료 구조에 단 하나의 요소가 들어있는 경우
  3. 자료 구조의 첫 번째 요소를 제거하거나 추가하는 경우
  4. 자료 구조의 마지막 요소를 제거하거나 추가하는 경우
  5. 자료 구조의 중간 부분을 처리하는 경우

### 3. addFirst 메서드
* 새로운 노드를 연결리스트 앞부분에 추가하는 과정
  1. 새로운 node 생성 
  2. 새로운 node의 next가 현재 head를 가리키도록 한다.
  3. head가 새로운 node를 가리키도록 한다.

* 위를 코드로 작성하면
    ```java
    public void addFirst (E obj){
        Node<E> node = new Node<>(obj);
        node.next = head;
        head = node;
    }
    ```

* 만약 2,3 번이 바뀐다면 어떻게 될까?
  - head를 새로운 노드를 먼저 가리킨다면
  - 원래 ```첫번째 노드를 가리키는 포인터 변수가 없어서 가비지 컬렉션이 작동```한다.

* 경계 조건
  * 비어있는 경우에도 문제 발생 x
  * 뒤에 요소가 존재하는 경우도 문제 발생 X

* ```시간 복잡도 = 1```

### 4. addLast 메서드
* 새로운 노드를 연결리스트 뒷부분에 추가하기 위해선 ```임시 포인터```를 사용한다.(head부터 시작해서 next를 사용하여 마지막 노드를 가기 위해선 너무 많은 next가 필요하기 때문)
* 기본적인 코드
    ```java
    public void addLast (E obj){
        Node<E> node = new Node<>(obj);
        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    ```
    * 마지막 노드만이 next포인터가 null을 가리키기 때문에 위의 코드처럼 작성하면 됨.
  
* __문제1. 경계 조건__
    * 아무것도 존재하지 않는 경우, temp = head이고, head는 null을 가리키고 있기 때문에 ```NullPointerException```에러가 발생.
    * 따라서 ```head == null```일 경우, __addFirst 메서드처럼 노드를 추가__ 한다.
    
  ```java
    public void addLast (E obj){
        Node<E> node = new Node<>(obj);
        Node<E> temp = head;
        if(head==null){
            head = node;
            currentSize++;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        currentSize++;
    }
  ```

* __문제2. 시간복잡도__
    * temp 변수가 마지막 노드까지 도달해야 하기 때문에 위의 코드는 시간복잡도가 ```O(n)```이 된다.
    * 하지만 애초에 ```tail 포인터 변수```가 마지막 노드를 가리키고 있으면 모든 노드를 거칠 필요가 없어져 시간 복잡도를 ```O(1)```로 만들 수 있다.
    ```java
    public void newAddLast (E obj){
        Node<E> node = new Node<>(obj);
        Node<E> temp = head;
        if(head==null){
            tail = head = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }
   ```
### 5. removeFirst 메서드
* 일반적인 경우엔 ```head = head.next```를 해주면 다음 노드를 가리키게 되고 그게 첫 번째 노드가 된다.
* 경계 상황
  1. 자료구조가 비어있는 경우
     * 위의 경우는 ```head```가 null을 가리키기 때문에 ```head = head.next```하게 되면 ```NullPointerException```이 발생한다.
     * 따라서 이 경우에는 그냥 null을 반환해주면 된다
  2. 자료구조에 단 하나의 요소만 있는 경우
     * ```head = tail = null```처리 해주면 된다.
```java
    public E removeFirst(){
        // 경계 조건 1
        if(head==null){
            return null;
        }
        E temp = head.data;
        // 경계 조건 2
        if(head.next == null){
            head = tail = null;
        }
        // 일반적인 경우
        else {
            head = head.next;
        }
        currentSize--;
        return temp;
    }
```

### 6. removeLast 메서드
* 마지막 노드만 삭제하기 위해선 ```tail```이 ```마지막에서 두번째 노드```를 가리키도록 하면 된다.
* 위를 위해선 __임시 포인터 변수__ ```current```와 ```previous```가 필요하다. current는 현재 위치를 가리키는 포인터, previous는 그 전 위치를 가리키는 포인터다.
* __current가 tail과 같은 순간 previous는 마지막에서 2번째 노드를 가리킨다__
* __경계 상황__
  * 자료구조가 비어있는 경우, 요소가 하나만 존재하는 경우 모두 ```removeFirst```와 같은 상황이기에, 동일하게 처리하고, ```removeFirst```메서드를 불러오면 된다.
```java
    public E removeLast(){
        // 자료구조가 비어있는 경우
        if(head==null) { return null; }
        E temp = head.data;
        // 자료구조에 단 하나의 요소만 있는 경우
        if(head == tail){
            return removeFirst();
        }

        Node<E> current = head, previous = null;
        while(current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = null;
        currentSize--;
        return temp;
    }
```

### 7. remove 메서드(contains 메서드, find 메서드)
* __remove 메서드의 과정__
  1. Comparable 인터페이스를 사용하어 __제거하고 싶은 요소의 위치를 찾는다.__
  2. ```바로 앞 노드의 next 포인터```가 ```다음 노드```를 가리키게 하면 된다.(```previous```,```current```포인터 변수로 각각 ```바로 앞 노드```, ```찾고자 한 노드```를 가리키도록 한다.)

* __경계 조건__
    1. ```노드가 1개인 경우```, ```첫 번째 노드를 삭제하는 경우```
        * 위 경우는 ```removeFirst 메서드```를 불러온다.
    2. ```마지막 노드를 삭제하는 경우```
        * 위 경우는 ```removeLast 메서드```를 불러온다.
    3. 자료구조가 비어있는 경우
        * 위 경우는 remove 메서드 과정을 따라가면 자연스럽게 처리된다.
```java
    public E remove(E obj){
        Node<E> current = head, previous = null;
        while(current != null){ // removeFirst와 달리 current != null 까지 보는 이유는 마지막 노드까지 처리해주기 위함
            if(((Comparable<E>)obj).compareTo(current.data) == 0){ // 찾은 경우
                if(current == head){ return removeFirst();} // 1번째 노드인 경우
                if(current == tail){ return removeLast(); } // 마지막 노드인 경우
                currentSize--;
                previous.next = current.next; // remove해주는 코드
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
```
* while문의 조건이 ```removeFirst```와 달리 ```current != null```인 이유는 마지막 노드까지 처리해줘야 하기 때문.
* 위 코드를 살짝만 변형하여 ```contains(find) 메서드```또한 만들 수 있다.
```java
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){ // removeFirst와 달리 current != null 까지 보는 이유는 마지막 노드까지 처리해주기 위함
            if(((Comparable<E>)obj).compareTo(current.data) == 0){ return true;}
            current = current.next;
        }
        return false;
    }
```
### 8. peek 메서드
* peek 메서드는 __하나의 요소를 살펴보기 위한__ 메서드.
* __경계 조건__
  * ```자료구조가 비어있는 경우``` : ```NullPointerException```을 발생시킬 수 있기 때문에 따로 처리.
* ```peakFirst```구현
```java
public E peekFirst(){
        if(head == null){return null;}
        return head.data;
    }
```
* ```peekLast```구현
```java
public E peekLast(){
    if(tail==null) return null;
    return tail.next;
}
```

### 9. 연결리스트 테스트
```java
public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = 10;
        for(int i = 0; i < n; i++){
            list.addFirst(i);
        }
        for(int i = 0; i < n; i++){
            System.out.println(list.removeFirst());
        }
    }
}
```
* 위와 같은 코드로 앞서 만들었던 연결리스트를 테스트 할 수 있음.

### 10. 반복자
* 일반적으로 배열의 각 요소를 반복하기 위해선 아래와 같은 방법을 사용한다.
```java
int arr[] = {1,2,3,4,5};
for (int i=0; i<arr.length; i++){
    system.out.println(arr[i]);
}
```

* 하지만 자바에선 아래와 같은 더 간단한 방법도 지원한다.
```java
int arr[] = {1,2,3,4,5};
for (int x:arr){
    system.out.println(x);
}
```

* 두번째와 같은 방법을 사용하기 위해선 ```Iterator 인터페이스```를 구현해야 한다.
```java
public class LinkedList<E> implements Iterable<E> {
    public Iterator<E> iterator() {
        return new IteratorHelper<>();
    }

    class IteratorHelper<E> implements Iterator<E> {
        LinkedList<E>.Node<E> index;

        public IteratorHelper() {
            index = (LinkedList<E>.Node<E>) head;
        }

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E val = index.data;
            index = index.next;
            return val;
        }
    }
}
```

### 11. 이중 연결 리스트
* ```이중 연결 리스트```는 단일 연결 리스트에 바로 전 노드를 가리키는 ```previous 포인터```를 추가한 연결 리스트.
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20240318174216/Doubly-Linked-List-in-Data-Structure.webp">
< 출처 : https://www.geeksforgeeks.org/why-use-a-doubly-linked-list/ >   
   

* __장점__ : ```removeLast``` 메서드 사용시에 단일 연결리스트에선 바로 전 노드를 찾기 위해서 처음부터 시작해야하는 반면, ```마지막 노드의 previous 포인터```를 사용하면 ```O(1)```로 ```removeLast 메서드```를 실행할 수 있다.
* __단점__ : ```previous 포인터```가 추가되기 때문에, 노드를 추가/삭제하는 과정이 복잡해짐.

### 12. 원형 연결 리스트
* ```원형 연결 리스트```는 __마지막 노드의 next포인터가 연결리스트의 처음 노드를 가리키는__ 연결 리스트.
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20240402130347/circular-linked-list-copy.webp">
< 출처: https://www.geeksforgeeks.org/circular-linked-list/ >   
    

* 해당 연결 리스트가 원형 연결 리스트인지 알 수 있는 방법
  1. 임시 포인터 temp가 head에서 시작해서 ```temp.next == head```가 되는지 확인.(```O(n)```)
  2. tail 포인터를 활용해서 ```tail.next == head```인지 확인.(```O(1)```)

### 13. 배열과 연결리스트 비교 (feat. 스택과 큐)
* 배열에서 처음, 끝에 요소를 추가,삭제하는 메서드를 살펴보자.
    * __addLast, removeLast__ : 배열의 크기와 처음 주소를 알기 때문에, 마지막 칸에 추가만 해주면 됨.(```O(1)```)
    * __addFirst__ : 배열은 순서를 유지하려 하기 때문에, 배열 첫 칸에 요소를 추가하기 위해선 뒤의 요소를 모두 한 칸씩 뒤로 옮겨줘야 한다.(O(n))
    * __removeFirst__ : 첫 요소를 삭제하는 경우에도 삭제하고 뒤의 요소들을 모두 한 칸씩 앞으로 옮겨줘야 한다.(```O(n)``)
* 위의 속성 때문에, 배열을 활용해 ```큐,스택```을 만들때 이슈가 발생한다.
    * __스택__ : ```스택```의 경우에는 ```addLast, removeFirst``` 만 있으면 되기 때문에, 별다른 이슈가 발생하지 않는다.
    * __큐__ : ```큐```의 경우에는 ```addLast, removeFirst``` 혹은 ```addFirst, removeLast``` 쌍으로 사용해야 하기에, 무조건 하나는 ```O(n)```인 비효율적인 작업을 해야 하는 이슈가 발생.
* __배열 vs 연결리스트__
  * __속도__ : 배열 > 연결리스트
  * __메모리 사용량__ : 배열 < 연결리스트
  * __크기__ : 배열 -> 고정 / 연결리스트 -> 유연함.

### 6일차 공부하면서 배운점/느낀점
* 연결 리스트에 대해서 예전에 공부해서 알고 있었던 내용이 많았지만, 그걸 자바 코드로 설명해주고, 직접 구현해보니 더 와닿고 재밌는 경험이었다.
* 특히 경계조건에 대한 설명으로 연결 리스트에 대해 더 엄밀하고, 더 생각할 수 있는 기회가 되었다.

< 6일차 출처 : https://www.boostcourse.org/cs204/joinLectures/184801?isDesc=false >
## 7일차 - Hash(해시)
### 1. 해시 소개
* 연결리스트의 단점은 리시트의 요소를 찾고 싶을 땐, 무조건 모든 요소를 살펴봐야 한다는 점.
* 이런 단점을 해결하여, ```key```와 연관된 ```value```로 연결되어, 키가 주어지면 그와 연결된 값을 바로 찾을 수 있는 자료구조.
* 이러한 아이디어 __associative array__ 에서 시작되었음.
<img src="https://i.namu.wiki/i/_KShrtIk7t_mXXZhVJDuwtk0r5cMWq1hxcS_YWmt-AO3eoF5wjUQHPGHkrtlJ5cL3WeRkkEoC1fwS41QypVtsmTDXIZ5jugFF6IP8quFB1e9B-S3FTfXFalH9oMVmwp-QvqdNmLEwkjSp7MP6ZLvCw.webp">

< 출처 : https://namu.wiki/w/%ED%95%B4%EC%8B%9C >   

### 2. 해시 함수.
* ```key```로 들어오는 값을 위해선 그 값을 그대로 사용할 순 없고, ```해시 함수```를 통해 ```정수값```으로 바꾸어 사용해야 한다.
* __```해시함수```를 위한 고려사항.__
  * __데이터의 속성__ (예를 들어, 주민번호 뒷자리 이용 -> 주민번호 앞자리 제거) 
  * __연산이 빨라야 함.__
  * __두 요소가 "같다면", 같은 값을 반환해야 한다.__
  * __같은 실행 환경일 경우 같은 객체는 같은 값이 나와야 한다.__
  * __코드를 새로 실행하면(실행 환경이 달라지면), 다른 값이 나올 수 있다.__(예를 들어, Object의 ```hashCode 메서드(해시 함수)```는 객체의 메모리(힙) 주소를 이용해 만들어 지기 때문에 실행마다 해시 값이 달라질 수 있음.)
  * __최대한 충돌이 일어나지 않도록 해야 한다.__

### 3. 해시 충돌
* __서로 다른 값의 데이터 들의 키값(해시값)이 일치__ 하는 경우.
<img src="https://cphinf.pstatic.net/mooc/20210430_85/1619713178893RneiL_PNG/mceclip0.png">

### 4. 문자열에서의 해시 함수
* 문자열 "this"를 해시로 나타내기 위한 방법?
  * 각 문자는 __유니코드__ 로 변환이 가능하고,
  * 각 문자의 유니코드의 합을 해시값으로 할 수 있을 것이다.
  * __하지만 이 경우, 문자열의 구성 문자만 같으면("tish", "hits")와 같은 해시값을 갖는다__
* __실제 문자열의 해시 값을 구하는 방법__
  * ```hash = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]```
```java
public int hashCode(String s) {
	int g=31;
	int hash=0;
	// 문자열을 숫자로 나타내기
	// 상수 g를 문자열 반대 위치(제일 처음 위치했으면 n-1)만큼 제곱한 뒤 곱합니다.
	for (int i=0; i<s.length; i++)
		hash = g*hash + s.charAt(i);
	return hash;
}
```

### 5. 해시 크기 최적화
* ```해시 충돌```을 피하기 위해 다음과 같은 방법으로 __해시 크기를 최적화__ 한다.
  1. 해시의 크기를 ```홀수```로 설정 -> ```%```연산시, 다양한 값이 나오도록 함.
  2. 해시의 크기를  ```소수```로 설정 -> 나머지가 다양하게 나오도록 함.
  < 더 자세한 설명 : https://halfmoonbearlog.tistory.com/73 >

### 6. 양수로의 변환
* ```hashCode 메서드```에서는 음수가 나올 수도 있다.
* 그리고 Java에선 음수의 모듈러 연산의 결과는 음수로 나올 수 있다.
* 하지만 __테이블의 인덱스로는 양수 밖에 사용할 수 없기 때문에__ , 이를 양수로 변환해줘야 한다.
```java
//data의 index결정
int hashval = data.hashCode(s);
hashval = hashval & Ox7FFFFFFF;
hashval = hashval % tableSize;
```
* 음수는 __```최상위 비트```가 1이기 때문에,__ 이를 0으로 바꿔주면 양수로 변환할 수 있다.
* 그렇게 하면 양수인 값의 table의 index로 사용할 수 있다.

### 7. loadFactor 메소드
* ```loadFactor(적재율)```은 __해시에 데이터가 얼만큼 있는지__ 알려준다. 
* 적재율은 ```λ```로 나타내고, 이는 ```항목수/해시 테이블 크기```로 구할 수 있다.
* 이 값을 통해 __해시 충돌이 일어나지 않도록 해시의 크기를 조절한다.__
* array를 기반으로 만든 자료구조는 __λ이 0.6~0.7을 넘으면__ 테이블 크기의 조절을 생각해봐야 한다.

### 8. 충돌 해결
* 해시 충돌은 필연적으로 발생하고 이를 해결하는 방법은 다음과 같다.
  1. __선형 조사법(linear probing)__
     * 채우려는 공간에 자료가 존재한다면, 비어있는 칸이 존재할 때까지 __다음 칸__ 을 확인한다. 그리고 비어있는 칸을 찾으면 __그곳에 자료를 넣고, 위치가 바뀐 사실을 알려줘야 합니다.__
     * 위의 방법을 이용하면, 자료를 삭제할 때 ```null```을 넣으면 안된다. __그 뒤에 다른 요소를 찾기 위해 비웠다는 표시를 해줘야 한다.__
     * 이는 __자칫 자료__ 가 뭉쳐 비효율적 방법이 되버린다.

  2. __2차식 조사법(quadratic probing)__
        * 선형 조사법과 비슷하지만, 다음 칸 대신 __1부터 순서대로 제곱한 숫자(1<sup>2, 2<sup>2, 3<sup>2, ...) 를 확인하여 자료를 넣는 방법.
  
  3. __이중 해싱(double hashing)__
        * __hashCode 함수를 2개__ 사용하여, 값이 존재한다면, __두번째 hashCode 값을 더한 칸__ 에 자료를 넣는 방법.
        * 장점 : 위의 두 방법보다 고르게 자료를 넣을 수 있음.
        * 단점 : 모든 자료가 2개의 hashCode를 갖는다는 보장이 없기에, 활용하기에 여러움.

### 9. 체이닝(Chaining)
* __체이닝__ 은 __테이블의 요소 마다 연결 리스트__ 를 만들어 많은 데이터를 수용할 수 있도록 하는 방법.
* 체이닝을 활용하면 __수용 가능한 요소 개수에 제한이 없어지고, 크기 조정도 자주 할 필요가 없어진다.__
   

<img src="https://cphinf.pstatic.net/mooc/20210430_91/16197137708007dMyE_PNG/mceclip2.png">
   
 
* ```적재율 λ``` = ```항목 개수 / 사용 가능한 체인 개수``` 
* 체이닝의 특성으로 한 체인에 여러 개의 항목이 들어갈 수 있어 ```적재율 λ```은 1보다 커질 수 있다. 
    
 
* __최선의 경우__ 에는 ```연결리스트```의 특성에 따라 __add, remove, find__ 등을 ```O(1)```에 수행할 수 있다.
* 하지만 __최악의 경우__ 즉, 하나의 연결리스트에 너무 많은 요소가 들어간 경우에는 ```O(n)```이 돼버려, hashtable의 장점을 살릴 수 없게 된다.

### 10. Rehashing
* 체인 해시에서 ```적재율 λ```이 일정 수준이상 넘어가면, ```크기 조정```을 해야한다.   
    

* 이를 위해선 일단 __테이블의 크기를 2배로 늘린다.__
* 그런 다음 원래 테이블에 있던 요소를 같은 index로 옮겨주기만 하면 될까?
* __아니다!__ 그 이유는 다음과 같다.
```java
// data의 index 결정
int idx = x.hashCode(s);
idx = idx & ox7FFFFFFF;
idx = idx % tableSize;
```
* 위는 데이터를 위한 ```index```를 구하는 코드이다.
* 그런데 ```tableSize```가 달라졌기 때문에, 같은 데이터라 하더라도, 테이블 크기가 달라지면 ```index```가 달라져 원하는 값을 찾을 수 없다.
    
 
* 그렇기에 __원래 테이블의 모든 요소__ 를 __2배 커진 배열의 크기를 넣어 구한 ```index```에 넣어줘야 한다.__

### 11. HashElement 내부 클래스
```java
class HashElement<K,V> implements Comparable<HashElement<K,V>>{
        // 키, 값 정의
        K key;
        V value;
        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }
        // compareTo 함수
        public int compareTo(HashElement<K,V> o){
            return ((Comparable<K>)this.key).compareTo(o.key);
        }
    }
```
* 값을 비교하기 위해 ```Comparable 인터페이스```를 구현하기 위해, ```compareTo 메소드```를 정의.
    * 키 값만 같으면 같은 ```HashElement```라고 판단.
    * 위를 위해선 key의 타입(클래스)에서 ```compareTo```가 정의되어 있어야 함.

### 12. Hash 생성자
```java
public class Hash<K,V>{
    LinkedList<HashElement<K,V>>[] harray;
    public Hash(int tableSize){
        this.tableSize = tableSize;
        harray = (LinkedList<HashElement<K,V>>[])new LinkedList[tableSize]; // 제네릭 배열을 위한 형변환
        // 연결리스트 체이닝 
        for(int i=0; i<tableSize; i++){
            harray[i] = new LinkedList<>();
        }
        numElements = 0;
        maxLoadFactor = 0.75;
    }
}
```
* __```loadFactor```가 너무 작으면__ 크기 조정을 자주 해줘야 하기 때문에, 비효율적이고
* __```loadFactor```가 너무 크면__ 테이블 크기에 비해 요소가 너무 많아, 탐색 시에 시간이 많이 걸림.
* __적당한 크기의 ```loadFactor```가 필요.

### 13. add, remove 메소드
* __add 메소드__
```java
    public boolean add(K key, V value){
        // resize
        if(loadFactor() > maxLoadFactor) resize(tableSize*2);

        // 키,값을 통해 저장해놓을 object he 정의
        HashElement<K,V> he = new HashElement<>(key, value);
        // he의 index찾기
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        // add he
        harray[hashVal].addFirst(he);

        numElements++;
        return true;
    }
```
* ```loadFactor```가 너무 커질 경우 ```resize```해줘야 한다.
* ```key```와 ```value```를 가지는 ```해시 요소```를 생성해서 테이블에 넣어주는 메소드
    
 
* __remove 메소드__
```java
    public boolean remove(K key, V value){
        // 삭제하고 싶은 데이터를 찾기 위해 키 값이 같은 object 생성
        HashElement<K,V> he = new HashElement<>(key, value);
        // he의 index찾기
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        // add he
        harray[hashVal].remove(he);

        numElements--;
        return true;
    }
```
* 삭제하고 싶은 ```key```를 가지는 해시요소를 만들어 key값이 같은 해시 테이블 내 요소를 삭제한다.

### 14. getValue 메소드
```java
    public V getValue(K key){
        // 해당하는 index찾기
        int hashVal = key.hashCode() & 0x7FFFFFFF % tableSize;

        // harray[index]의 LinkedList에서 key값이 같은 element 찾기 위해 반복.
        for(HashElement<K,V> he : harray[hashVal]){
            if(((Comparable<K>)he.key).compareTo(key) == 0) return he.value;
        }
        return null;
    }
```
* ```key```로 ```hashVal```을 구해 그 index의 연결리스트를 순회하며 ```key```값을 가지는 ```해쉬 요소```의 ```value```를 반환.
* __시간복잡도__ : 일반적인 경우 ```O(1)```이지만, 연결리스트에 너무 많은 요소가 들어있는 경우, 즉 최악의 경우에는 ```O(n)```이 된다.

### 15. resize 메소드
```java
    public void resize(int newSize){
        LinkedList<HashElement<K,V>> [] newArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[newSize];

        for(int i=0; i<newSize; i++){
            newArray[i] = new LinkedList<>();
        }

        for(K key : this){
            V val = getValue(key);
            HashElement<K,V> he = new HashElement<>(key, val);
            int hashVal = key.hashCode()&0x7FFFFFFF%newSize;
            newArray[hashVal].addFirst(he);
        }
        harray = newArray;
        tableSize = newSize;
    }
```
* 위의 __reHashing__ 의 파트에서 설명했듯, ```resize```를 할 때는, 새로운 크기의 해시 테이블을 만들어 __원래 테이블의 모든 요소를 옮겨 주어야 한다__
* 위의 과정에서 ```hashVal```은 새로운 크기로 나눈 값이 들어가야 한다.

### 16. KEY 반복자
```java
    class IteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;
        // key반복자
        public IteratorHelper(){
            keys = (T[]) new Object[numElements];
            int p = 0;
            for(int i=0; i<tableSize; i++){
                for(HashElement<K,V> he : harray[i]){
                    keys[p++] = (T)he.key;
                }
            }

            position = p;
        }
        
        // 끝을 확인할 때 사용
        @Override
        public boolean hasNext() {
            return position < keys.length;
        }
        
        // 해시의 모든 요소를 확인할 때 사용
        @Override
        public T next() {
            if(!hasNext()) return null;
            return keys[position++];
        }
    }
```
* ```resize 메소드```에서 ```forEach문```을 사용하기 위해 ```반복자```를 설계해준다.
* 생성자에서 ```key```값만 갖는 배열을 만든 후, 해시 테이블의 모든 요소를 순환하며 ```key```를 배열에 모두 넣는다.
* 이제 ```next 메소드```에선 배열의 값만 return 해주면 된다.

## 8일차 - 트리
### 1. 트리 기본 개념
<img src="https://cphinf.pstatic.net/mooc/20210430_94/1619715766084zCR85_PNG/mceclip0.png">

* 가계도처럼 __노드를 나무 형태로 저장하는 자료구조__ 를 의미. 위의 그림과 같이 모든 노드는 __부모와 자식 관계__ 로 이루어짐.
* __루트(ROOT)__ : 트리의 최상단에 위치한 노드. 트리 자료구조에서 가장 중요한 노드(특히 힙에서)
* __잎(leaf)__ : 트리의 최하단에 위치한 노드. 즉, 자식이 없는 노드.
* __간선(edge)__ : 두 노드를 연결하는 선. 뿌리로부터의 노드 개수로 ```level```을 결정. (예를 들어, 위의 그림에서 ```leaf```는 ```root```사이에 간선이 두 개 존재하기에, ```level 2```)

### 2. 트리의 종류
1. __완전 트리(Complete binary Tree)__   
* __마지막 level을 제외한 레벨의 노드는 꽉 차있고, 마지막 level의 노드들은 왼쪽부터 오른쪽으로 차있는 형태의 트리__
<img src="https://cphinf.pstatic.net/mooc/20210525_253/1621925636427oUwwc_PNG/mceclip0.png">   
  


2. __Full Binary Tree__
* __모든 노드의 자식이 0개 혹은 2개인 트리__. 즉, __leaf node가 아닌 노드는 모두 2개의 자식을 가진다.__

    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221229135813/full.png">
    
    < 출처 : https://www.geeksforgeeks.org/full-binary-tree/ >
    
 

3. __Perfect Binary Tree__
* __모든 leaf가 아닌 노드는 두개의 자식을 가지고, 모든 leaf들은 같은 레벨인 트리.__
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20220630154756/img2.jpg">
< 출처 : https://www.geeksforgeeks.org/perfect-binary-tree/ >

### 3. 힙
* __정의__ : 최댓값, 최솟값을 빠르게 찾기 위한 __완전이진트리를 기반으로 한 자료구조__
* __종류__ 
  * __최대힙(Max heap)__ : 부모 노드가 자식 노드보다 큰 힙. __루트에 가장 큰 수가 오게 됨__
  * __최소힙(Min heap)__ : 부모 노드가 자식 노드보다 작은 힙. __루트에 가장 작은 수가 오게 됨__

### 4. 힙 추가/삭제
* 힙에 새로운 요소를 추가하거나 제거하기 위해선 __힙 속성(```Heap Property```)__ 을 지켜야 한다.(최대힙의 경우 부모 노드가 자식 노드보다 커야 함)
* __추가__ 
  1. 비어있는 공간에 노드 추가
  2. 부모 노드보다 큰 숫자인지 확인하고 크면 두 노드의 자리를 바꿈
  * 이 과정을 반복하여 __힙 속성을 만족시킴__(```trickle up```)
  <img src="https://cphinf.pstatic.net/mooc/20210525_22/1621923502381xjAl3_PNG/mceclip0.png">   
  
  
* __삭제__
  1. 루트 노드를 삭제
  2. 마지막 요소를 루트에 넣어준다.
  3. 힙의 규칙을 만족시키기 위해 루트에서부터 자식 중 큰 자식과 자리를 바꿈
    * 이 과정을 반복하여 __힙 속성을 만족시킴__(```trickle down```)

* Q&A 
  * Q) 루트를 제거할 때, 트리의 마지막 요소를 루트 자리에 넣어주는 이유는?
  * A) 루트를 삭제하면 트리 구조를 유지하기 위해 다른 노드가 들어가야함.
  * A) 자식 노드 중 특정 위치의 큰 값이 루트에 들어가면, 그 후 많은 노드들을 다시 조정해야 하기에 비효율적.
  * A) 마지막 노드를 루트로 올려서 ```trickle down```하는 것이 구조적으로 그 노드에 대해서만 생각해주면 되는 것이기에 더 효율적

### 5. trickle up
* 힙은 ```완전이진트리```이기 때문에 자식과 부모의 위치를 계산할 수 있다
* __자식__ : ```2*parent+1``` or ```2**parent+2```
* __부모__ : ```floor((child-1)/2)```
* 위의 성질을 이용해서 ```trickle up```함수를 작성할 수 있다.
* __부모와 자신을 비교해 부모보다 더 크면 swap을 반복__
```java
    public void trickleUp(int position){
        if(position == 0) return;

        int parent = (int)Math.floor((position-1)/2);
        if(((Comparable<E>)array[position]).compareTo(array[parent])>0){
            swap(position,parent);
            trickleUp(parent);
        }
    }
```

* Q&A
  * Q) 위 코드에서 

### 6. trickle down
* 루트의 위치부터 왼쪽 자식 or 오른쪽 자식과 크기를 비교하며 더 큰 것과 swap하며 내려감
```java
    public void trickleDown(int position){
        int left = 2*position+1;
        int right = 2*position+2;

        // 마지막에 왼쪽 자식이 큰 경우
        if(left == lastPosition && ((Comparable<E>)array[position]).compareTo(array[left])<0){
            swap(position,left);
            return;
        }
        // 마지막에 오른쪽 자식이 큰 경우
        if(right == lastPosition && ((Comparable<E>)array[position]).compareTo(array[right])<0){
            swap(position,right);
            return;
        }
        // 마지막에 부모가 더 큰 경우
        if(left >= lastPosition || right >= lastPosition){
            return;
        }
        // 왼쪽 자식이 큰 경우
        if(((Comparable<E>)array[left]).compareTo(array[right])>0 && ((Comparable<E>)array[position]).compareTo(array[left])<0){
            swap(position,left);
            trickleDown(left);
            return;
        }
        // 오른쪽 자식이 큰 경우
        else if(((Comparable<E>)array[position]).compareTo(array[right])<0){
            swap(position,right);
            trickleDown(right);
            return;
        }
        // 나머지 중간에 부모가 더 큰 경우에는 그냥 return 처리된다.
    }
```
* Q&A
  * Q. 루트의 정보를 없애는 대신 swap 함수를 이용하여 제거하면 어떤 점이 좋나요?
  * A. 루트를 마지막 위치와 swap한 것을 모아두면 차례되로 정렬이 됨.
### 7. heap sort
* 힙 규칙에 맞게 숫자의 순서를 맞추는 과정을 __힙 정렬 알고리즘__ 이라고 한다. 임의의 숫자들을 나열하고, __힙 규칙에 맞게 trickleDown을 반복하면__ 정렬이 완료된다.
* __힙 정렬 과정__ (chat gpt)
  - 초기 배열: [6, 2, 3, 5, 4]
  1. 최대힙 생성 후 첫 번째 최대값인 6과 마지막 값을 교환 -> [4, 2, 3, 5, 6]
  2. 최대힙 재구성 -> [5, 2, 3, 4, 6]
  3. 최대값인 5와 마지막 값을 교환 -> [3, 2, 4, 5, 6]
  4. 최대힙 재구성 -> [4, 2, 3, 5, 6]
  5. 반복하여 [2, 3, 4, 5, 6]이 됨.   
   
* ```최대힙```을 remove하면 heap의 최솟값만 pop하기 때문에, 그것들을 배열의 마지막에서 반대로 저장하면 정렬이 됨.
* remove할 때마다 ```trickleDown```해야 하기 때문에, 각 요소마다 O(logn)의 시간 복잡도가 나오고, 결론적으로 __힙 정렬은 ```O(nlogn)```의 시간복잡도__를 가진다.

### 8. 트리 : Node
* 트리에서 __부모 노드보다 큰 노드는 오른쪽__, __작은 노드는 왼쪽__ 에 위치해야 한다.
* 그래서 트리에서 어떤 노드를 찾을 경우, 부모노드보다 크면 오른쪽, 작으면 왼쪽으로 이동하면 된다.
* 이러한 특성으로 ```contains 함수```는 각 부모를 기준으로 절반의 데이터는 무시하여 ```O(logn)```의 시간복잡도를 가짐.
    
 
* 연결리스트에서의 노드와 비슷하게 __트리에서의 노드__ 는 __left,right 포인터와 data__ 로 구성됨.
```java
public class Node<E> {
    E data;
    Node<E> left,right;
    public Node(E data) {
        this.data = data;
        left = right = null;
    }
}
```
* Q&A
    * Q. left, right 포인터는 엄마 노드에서 자식 노드로 향하는 포인터입니다. 자식 노드에서 엄마 노드로 향하게 하면 어떤 문제가 생길 수 있을까요?
    * A. parent 포인터가 있으면 부모에게도 접근할 수 있어 보다 많은 기능을 구현할 수 있겠지만, 그만큼 구현이 복잡해진다는 단점이 생김.
  

### 9. 트리 : add (recursion)
* __트리에서 add하는 과정__
  1. root부터 시작.
  2. __트리의 규칙__ 에 맞춰 내려감.
  3. __null인 부분__ 을 찾았으면 그 곳에 새로운 노드 추가.
* __재귀함수__ 를 이용해서 구현.
```java
    // 사용자가 접근하는 add함수
    public void add(E obj){
        if(root == null){
            root = new Node<>(obj);
        }
        else add(obj,root);
        currentSize++;
    }

    // 실제로 사용되는 add함수
    private void add(E obj, Node<E> node){
        if(((Comparable<E>)obj).compareTo(node.data)>0){
            //go to right
            if(node.right == null){
                node.right = new Node(obj);
                return;
            }
            add(obj, node.right);
            return;

        }
        //go to left (같을 경우에도 왼쪽으로 감)
        if(node.left == null){
            node.left = new Node(obj);
            return;
        }
        add(obj, node.left);
        return;
    }
```
* Q&A
    * Q. 재귀 함수를 활용하였을 때의 장점은 무엇인가요?
    * A. add함수의 경우 얼마나, 어떻게 내려가야 하는지 알 수 없는데 재귀 함수를 사용하면 그때그때의 기능을 구현해놓으면 그에 맞게 기능할 수 있다,

### 10. 트리 : contains
* __트리에서 contains 함수 실행 과정__
  1. 루트에서 시작
  2. __트리 규칙에 따라 내려감__
  3. 내려가다가 __요소를 찾으면 true__, __찾지 못하고 null까지 내려가면 false__ 반환.
* __재귀함수__ 를 이용해서 구현.
```java
    // 사용자가 접근하는 contains함수
    public boolean contains(E obj){
        return contains(obj,root);
    }

    // 실제 사용되는 contains함수
    private boolean contains(E obj,Node<E> node){
        // 요소를 찾아 내려갔는데, null이 나오는 경우 -> 요소가 존재하지 않는 경우.
        if(node == null) return false;
        // node의 data와 일치.
        if(((Comparable<E>)obj).compareTo(node.data)==0) return true;
        // data가 node.data보다 큰 경우
        if(((Comparable<E>)obj).compareTo(node.data)>0) contains(obj,node.right);
        // data가 node.data보다 작은 경우
        return contains(obj,node.left);
    }
```
* Q&A
    * Q. 트리가 비어있을 경우에도 contains 함수는 잘 동작하나요?
    * A. 트리가 비어있을 경우 private contains함수에 들어가자마자 ```node == null```에서 ```root == null```에 걸려 false를 올바르게 return한다.

### 11. 트리 : 제거
* 트리에서 요소를 제거하는 경우엔 __자식 노드의 개수__ 에 따라 달라진다.
1. 리프 노드를 제거하는 경우
   * 그 노드의 __부모 노드의 포인터를 null__ 로 지정.
2. 삭제하려는 노드의 자식 노드가 하나인 경우
   * 그 노드의 __부모 노드의 포인터를 자식 노드와 연결__ . 이때 주의해야 할 점은 부모 노드는 그 노드와 동일한 포인터를 사용해야함.(ex : right or left)
3. 삭제하려는 노드의 자식 노드가 두개인 경우
   * 삭제하려는 노드를 루트로 하는 서브트리에서 __중위 후속자와 중위 선임자들 중 하나의 위치와 변경한 뒤 리프 노드가 된 노드를 삭제__
   * __중위 후속자(in order successor)__ : 제거하려는 노드에서 오른쪽으로 한 번 갔다가 왼쪽으로 쭉 내려갔을 때 나오는 리프 노드. 즉, __제거하고자 하는 노드보다 큰 노드 중 가장 작은 노드__
   * __중위 선임자(in order predessor)__ : 제거하려는 노드에서 왼쪽으로 한 번 갔다가 오른쪽으로 쭉 내려갔을 때 나오는 리프 노드. 즉, __제거하고자 하는 노드보다 작은 노드 중 가장 큰 노드__
   * (중위 선임자, 후속자라고 하는 이유는 중위 순회를 했을 때, 리프 노드 전,후에 방문하는 노드기 때문)

* Q&A
  * Q. 자식 노드가 2개인 노드를 제거할 때, 중위 후속자 혹은 중위 선임자와 자리를 바꾸는 이유는 무엇인가요?
  * A. 중위 후속자와 중위 선임자와 루트를 바꿔야 트리의 정렬 구조를 해치지 않고, 루트에 위치했던 노드가 리프 노드로 가서 삭제 작업이 간단해지기 때문이다.

### 12. 트리 : 회전
* 회전이란 __균형 잡힌 트리__ 를 만들기 위해 __트리의 노드 위치를 바꾸는 과정__ .
* 밑의 그림처럼 연결리스트와 같이 __한 방향으로만 나열된 트리__ 를 균형 잡혀있지 않은 트리라고 한다. 
* 균형 잡혀 있지 않은 트리는 특정 요소를 탐색할 때, 균형잡힌 트리(```O(logn)```)과 달리 ```O(n)``` 의 시간 복잡도를 가져 비효율적이다.

<img src="https://www.eecs.umich.edu/courses/eecs380/ALG/niemann/s_fig33.gif">

< 출처 : https://www.eecs.umich.edu/courses/eecs380/ALG/niemann/s_bin.htm >

* 따라서 균형잡힌 노드로 만들기 위해 __조부모 노드, 부모 노드, 자식 노드의 크기 관계에 따라 우측 회전 or 좌측 회전__ 을 진행. 재정렬된 트리의 루트는 항상 __중간 크기의 요소__ 가 된다.

1. __왼쪽 서브트리__ 에서 불균형이 발생한 경우

<img src="https://cphinf.pstatic.net/mooc/20210430_213/1619718087522X9K3C_PNG/mceclip0.png">

* 위의 경우엔 __grandparent 노드를 right rotation__ 하여, grandparent 노드를 parent 노드의 오른쪽 자식 위치로 옮겨줌.

2. __오른쪽 서브트리__ 에서 불균형이 발생한 경우

<img src="https://cphinf.pstatic.net/mooc/20210430_74/1619718245957AApud_PNG/mceclip2.png">

* 위의 경우엔 __grandparent 노드를 left rotation__ 하여, grandparent 노드를 parent 노드의 왼쪽 자식 위치로 옮겨줌.

```java
    // 왼쪽 서브트리에 불균형이 있는 경우 -> right rotate
    public Node<E> rightRotate(Node<E> node){
        Node<E> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }
    
    // 오른쪽 서브트리에 불균형이 있는 경우 -> left rotate
    public Node<E> leftRotate(Node<E> node){
        Node<E> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }
```

* __트리가 한 쪽으로 치우치지 않은 경우__
1. __오른쪽 자식의 왼쪽 서브트리__ 에서 불균형이 발생한 경우

<img src="https://cphinf.pstatic.net/mooc/20210430_88/1619718643248TWX2G_PNG/mceclip0.png">

* 위의 경우엔 __부모 노드에 대해서 right rotation__ 하고, __grandparent 노드를 left rotation__ 해서 해결.

2. __ 왼쪽 자식의 오른쪽 서브트리__ 에서 불균형이 발생한 경우

<img src="https://cphinf.pstatic.net/mooc/20210430_88/1619718804552Qh7HW_PNG/mceclip1.png">

* 위의 경우엔 __부모 노드에 대해서 left rotation__ 하고, __grandparent 노드를 right rotation__ 해서 해결.

```java
    // 오른쪽 자식의 왼쪽 서브트리에 불균형이 있는 경우 -> 부모 노드에 대해서 right rotation, 조부모 노드를 left rotation
    public Node<E> rightLeftRotate(Node<E> node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }
    
    // 왼쪽 자식의 오른쪽 서브트리에 불균형이 있는 경우 -> 부모 노드에 대해서 left rotation, 조부모 노드를 right rotation
    public Node<E> leftRightRotate(Node<E> node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
```

### 8일차 공부를 하며 느낀 점.
* 트리 자료구조에 대해서 배우면서 포인터에 대한 개념이 조금씩 더 와닿는 것 같다.
* 조금은 복잡할 수 있는 개념(우측회전, 좌측회전)과 같은 개념들을 천천히 코드로 작성하며 익히니 더 잘 이해할 수 있었음.

## 9일차 - AVL 트리
### 1. AVL 트리 개념
* AVL 트리는 __스스로 균형을 잡는 ```자가 균형 트리```__ 이다. AVL 트리에서는 __왼쪽과 오른쪽의 높이 차이가 항상 1보다 작거나 같아야 함.__
<img src="https://cphinf.pstatic.net/mooc/20210430_169/1619719441354fPiUS_PNG/mceclip0.png">

### 2. AVL 트리 : 노드
* AVL 트리의 노드는 __data와 left,right 포인터와 동시에 parent 포인터를 가짐.__
```java
    public class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        public Node(T data){
            this.data = data;
            left = right = parent = null;
        }
    }
```

### 3. AVL 트리 : add 메서드
* __사용자가 호출하는 메서드__
    ```java
    public void add(E obj){
        Node<E> newNode = new Node<>(obj);
        // 트리가 비어있을 경우 root에 새로운 노드 대입
        if(root == null){
            root = newNode;
            currentSize++;
            return;
        }
        // 일반적인 경우에 재귀 add 메서드를 호출
        add(root,newNode);
    }
    ```
* __재귀 add 메서드__
    ```java
    private void add(Node<E> parent, Node<E> newNode){
        // 새로운 노드가 기존 노드보다 큰 경우 -> 오른쪽 자식으로
        if(((Comparable<E>)newNode.data).compareTo(parent.data) > 0){
            // 오른쪽 자식이 없는 경우 -> 오른쪽 자식에 새로운 노드
            if(parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            }
            // 오른쪽 자식이 있는 경우 -> 오른쪽 자식과 add 메서드
            else add(parent.right, newNode);
        }
        // 새로운 노드가 기존 노드보다 작거나 같은 경우 -> 왼쪽 자식
        else {
            if(parent.left == null){
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            }
            else add(parent.left, newNode);
        }
        // 노드를 추가한 뒤에는 균형이 맞는지 확인
        checkBalance(newNode);
    }
    ```
### 4. AVL 트리 : 균형 확인 메서드
* AVL 트리에서는 왼쪽과 오른쪽의 높이 차이가 1을 초과해서는 안되는 규칙을 항상 만족해야 한다. 
* 따라서, 노드를 추가했을 떄, 규칙을 벗어날 경우 ```회전```을 이용해서 균형을 맞춰야 한다.
* 그렇기 위해선 트리의 __높이 차이를 확인하고, 균형을 맞추는 ```checkedBalance 메서드가 필요__
    ```java
    private void checkBalance(Node<E> node){
        // 해당 지점에서 균형이 맞지 않을 경우 그 노드를 기준으로 reBalance 진행
        (height(node.left) - height(node.right) > 1 || height(node.left) - height(node.right) < -1) rebalance(node);
        
        // 해당 지점이 정상인 경우 부모로 올라가서 다시 균형 확인 (루트까지 진행)
        if(node.parent == null) return;
        checkBalance(node.parent);
    }
    ```

### 5. AVL 트리 : rebalance 메서드
* rebalance 메서드에선 __어느 쪽에서 불균형이 발생했는지 확인하고 회전하여 균형을 맞춤__
    ```java
    public void rebalance(Node<E> node){
        // 왼쪽 자식 > 오른쪽 자식
        if(height(node.left) - height(node.right) > 1){
            if(height(node.left.left) > height(node.left.right)) { rightRotate(node); } // 왼쪽 서브트리 > 오른쪽 서브트리 -> right rotate
            else { leftRightRotate(node); } // 오른쪽 서브트리 > 왼쪽 서브트리 -> left-right rotate
        }
        // 오른쪽 자식 > 왼쪽 자식
        else {
            if(height(node.right.left) > height(node.right.right)) { leftRightRotate(node); }// 왼쪽 서브트리 > 오른쪽 서브트리 -> right-left rotate
            else { leftRotate(node); }
        }
        // 루트가 올 때까지 반복
        if(node.parent == null) root = node;
    }
    ```

## 10일차 - Red Black Tree
### 1. Red Black Tree : 소개
* ```Red Black Tree```는 자가 균형 이진 탐색 트리로서 다음의 규칙에 따라 균형을 맞춘다.
  1. 모든 루트는 검정색 or 빨간색이다.
  2. 루트는 항상 검은색이다.
  3. 새로운 노드는 항상 빨간색이다.
  4. __루트에서 리프까지의 모든 경로의 검정색 노드 개수는 같아야 한다.__
  5. __어떤 경로에도 빨간색 노드가 2개 연속으로 있어서는 안 된다.__
  6. 빈 노드는 검정색이라고 가정한다.
  
* 규칙 위반했을 때 균형을 맞추기 위한 방법
    * 이모 노드가 검정색인 경우 -> __회전 -> 부모 노드는 검정색, 자식 노드는 빨간색이 되어야 한다.__
    * 이모 노드가 빨간색인 경우 -> __색상 전환 -> 부모 노드는 빨간색, 자식 노드는 검정색이 되어야 한다.__
  
<img src="https://cphinf.pstatic.net/mooc/20210430_97/16197213821273KHVs_PNG/mceclip0.png">

* Q&A
  * Q) 레드 블랙 트리에서 검은색 노드 2개가 연속으로 있는 경우는 가능한가요?
  * A) 검정색 노드가 2개 연속된 경우는 상관없이 가능하다.

### 2. Red Black Tree : 클래스
* 일반 트리에서 노드의 색을 나타내는 ```black```불리언 변수, 나중에 계산의 편의를 위한 ```isLeftChild```불리언 변수를 추가한다.
    ```java
    public class RedBlackTree<K,V>{
        Node<K,V> root;
        int size;
        class Node<K,V>{
            K key;
            V value;
            Node<K,V> left,right,parent;
            boolean isLeftChild, black;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
                left = right = parent = null;
                isLeftChild = false;
                black = false;
            }
        }
    }
    ```
* Q&A
* Q) isLeftChild가 참이면 이모 노드는 어떻게 찾을 수 있나요?
* A) node.parent.isLeftChild -> node.parent.parent.right / !node.parent.isLeftChild -> node.parent.parent.left

### 3. Red Black Tree : add 메소드
```java
// 사용자가 호출하는 add 메서드
public void add(K key, V value){
    Node<K,V> newNode = new Node<>(key, value);
    if(root == null) {
        root = newNode;
        root.black = true;
        size++;
        return;
    }
    add(root,newNode);
    size++;
}

// 실직적으로 실행되는 add 메서드
private void add(Node<K,V> parent, Node<K,V> newNode){
    // 새 노드가 부모보다 큰 경우
    if(((Comparable<K>)newNode.key).compareTo(parent.key) > 0){
        // 부모의 오른쪽 자식이 비어있는 경우
        if(parent.right == null){
            parent.right = newNode;
            newNode.parent = parent;
            newNode.black = false; // 새로운 노드는 항상 빨간색
            newNode.isLeftChild = false; // 새로운 노드는 부모의 오른쪽 자식
            checkColor(newNode); // 최종적으로 들어갈 때, 트리의 균형 확인
        }
        add(parent.right,newNode);  // 자식이 비어있는 경우가 나올 때까지 내려감
        return;
    }
    // 부모의 왼쪽 자식이 비어있는 경우
    if(parent.left == null){
        parent.left = newNode;
        newNode.parent = parent;
        newNode.black = false;
        newNode.isLeftChild = true; // 새로운 노드는 부모의 왼쪽 자식
        checkColor(newNode);  // 최종적으로 들어갈 때, 트리의 균형 확인
    }
    add(parent.left,newNode);  // 자식이 비어있는 경우가 나올 때까지 내려감
}
```
* Q&A
  * Q) checkColor 메소드는 왜 필요한가요?
  * A) red black tree는 자가 균형 트리이기 때문에, 노드를 추가할 때마다 균형을 맞춰줘야 하기 때문

### 4. Red Black Tree : 색상 확인 메소드
* 규칙에 어긋난 노드가 있는 경우 균형을 맞추기 위한 메서드
    ```java
    // node.parent를 타고 올라가며 루트까지 균형 체크
    public void checkColor(Node<K,V> node) {
        // 루트까지 도달한 경우에 루트는 항상 black이기 때문에 설정해주고 return
        if(node == root){
            node.black = true;
            return;
        }
        
        // 빨간색 노드가 두 번 연속될 경우
        if(!node.black && !node.parent.black){
            correctTree(node);
        }
        
        // 부모까지 타고 올라가서 체크
        checkColor(node.parent);
    }

    public void correctTree(Node<K,V> node){
        // 이모노드의 색에 따라 대처가 달라지기에 이모노드를 먼저 찾아야 함.
        // 부모가 왼쪽 자식인 경우
        if(node.parent.isLeftChild){
            // 조부모의 오른쪽 자식이 비어있거나(검정색으로 가정), 검정색인 경우 -> 회전
            if(node.parent.parent.right == null || node.parent.parent.right.black){
                rotate(node);
                return;
            }  
            // 조부모의 오른쪽 자식이 빨간색인 경우 -> 색상 전환
            if(node.parent.parent.right != null){
                node.parent.black = true;
                node.parent.parent.black = false;
                node.parent.parent.right.black = true;
                return;
            }
        }
        // 부모가 오른쪽 자식인 경우
        else {
            // 조부모의 왼쪽자식이 비어있거나(검정색으로 가정), 검정색 인 경우 -> 회전
            if (node.parent.parent.left == null || node.parent.parent.left.black) {
                rotate(node);
                return;
            }
            // 조부모의 왼쪽 자식이 빨간색인 경우 -> 색상 전환
            if (node.parent.parent.left != null) {
                node.parent.black = true;
                node.parent.parent.black = false;
                node.parent.parent.left.black = true;
                return;
            }
        }
    }
    ```
* Q&A
  * Q) correctTree 메소드는 어떤 일을 하나요?
  * A) 트리에 균형이 맞지 않을 경우, 이모노드의 색에 따라 회전 혹은 색상 전환을 진행하여 Red Black Tree의 균형을 찾는 메서드
    
### 5. Red Black Tree : rotate 메서드
* 현재 노드와 현재 노드의 부모 노드의 위치에 따라 필요한 회전이 달라진다.
    ```java
    public void rotate(Node<K,V> node){
        // 현재 노드가 왼쪽 자식
        if(node.isLeftChild){
            // 왼쪽자식의 왼쪽 서브트리
            if(node.parent.isLeftChild){
                rightRotate(node.parent.parent); // 조부모 노드에 대해 rightRotate
                // Red Black Tree는 회전 후에는 부모노드는 검정색, 자식 노드들은 빨간 노드로 처리.
                node.black = false;
                node.parent.black = true;
                if(node.parent.right != null) node.parent.right.black = false; // node,parent.right에 대한 판별은 필요없어보임.
                return;
            }
            // 왼쪽자식의 오른쪽 서브트리
            leftRightRotate(node.parent.parent); // 조부모 노드에 대해 leftRightRotate
            node.black = true;
            node.left.black = false;
            node.right.black = false;
            return;
        } else {
            // 오른쪽 자식의 왼쪽 서브트리
            if(node.parent.isLeftChild){
                rightLeftRotate(node.parent.parent); // 조부모 노드에 대해 rightleftRotate
                node.black = true;
                node.left.black = false;
                node.right.black = false;
                return;
            }
            // 오른쪽 자식의 오른쪽 서브트리
            leftRotate(node.parent.parent); // 조부모 노드에 대해 leftRotate
            node.black = false;
            node.parent.black = true;
            node.parent.left.black = false;
            return;
        }
    }
    ```
  
### 6. Red Black Tree : leftRotate
* 이때까지 배운 leftRotate와 유사하지만, ```parent 포인터```와 ```isLeftPointer```가 추가되었기 때문에, 이를 고려해줘야 한다.
    ```java
    public void leftRotate(Node<K,V> node){
        Node<K,V> temp = node.right;
        node.right = temp.left;

        // temp.left가 node.right로 들어감.
        if(node.right != null){
            node.right.parent = node;
            node.right.isLeftChild = false;
        }
        // 조부모 노드가 루트인 경우
        if(node.parent == null){
            root = temp;
            temp.parent = null;
        }
        // 주부모 노드가 루트가 아닌 경우
        else {
            temp.parent = node.parent;
            if(node.isLeftChild){
                temp.parent.left = temp;
                temp.isLeftChild = true;
            } else {
                temp.parent.right = temp;
                temp.isLeftChild = false;
            }
        }
        temp.left = node;
        node.parent = temp;
        node.isLeftChild = true;
    }
    ```
* rightRotate는 leftRotate와 반대로만 진행해주면 된다.

### 7. Red Black Tree : leftRightRotate 메소드
* RedBlackTree에서의 __left,right Rotate__ 는 조부모의 부모와의 연결까지 했기 때문에, 앞서 배운 leftRightRotate보다 간단하다.
    ```java
    public void leftRightRotate(Node<K,V> node){
        leftRotate(node.left);
        rightRotate(node);
    }
    ```
* rightLeftRotate는 반대로 진행해주면 된다.

### 8. Red Black Tree : height 메소드
```java
    public int height(){
        if(root == null) return 0;
        return height(root)-1; // root에서 넘어올 때 +1 되기 때문에 -1 해줘야 함.
    }
    // height 메서드 오버로딩 (재귀 메서드)
    // left든 right든 가장 긴 경로의 길이를 구할 수 있음.
    public int height(Node<K,V> node){
        if(node == null) return 0;
        int leftHeight = height(node.left)+1;
        int rightHeight = height(node.right)+1;

        if(leftHeight > rightHeight){return leftHeight;}
        return rightHeight;
    }
```

### 9. Red Black Tree : 검정색 노드의 개수
* Red Black Tree의 규칙 중에는 루트에서 리프까지의 모든 경로의 검정색 노드 개수가 같아야 한다는 규칙이 있다.
* 이를 확인하기 위한 메서드
    ```java
    public int blackNodes(Node<K,V> node){
        if(node == null) return 0;
        int rightBlackNodes = blackNodes(node.right);
        int leftBlackNodes = blackNodes(node.left);

        // RedBlackTree의 규칙을 위반하는 경우(루트에서 리프까지의 경로까지 블랙노드의 수가 다른 경우) 발생 -> 오류 발생 or 해결
        if(leftBlackNodes != rightBlackNodes){
            // error 발생
            // 해결
        }

        // 현재 노드가 검정색이면 leftBlackNode++;
        if(node.black) leftBlackNodes++;
        return leftBlackNodes;
    }
    ```