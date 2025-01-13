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

## 7일차 - Hash(해시)
### 1. 해시 소개
* 연결리스트의 단점은 리시트의 요소를 찾고 싶을 땐, 무조건 모든 요소를 살펴봐야 한다는 점.
* 이런 단점을 해결하여, ```key```와 연관된 ```value```로 연결되어, 키가 주어지면 그와 연결된 값을 바로 찾을 수 있는 자료구조.
* 이러한 아이디어 __associative array__ 에서 시작되었음.
<img src="https://blogs.mathworks.com/matlab/files/2022/09/Dictionary2022b_1.png">

< 출처 : https://blogs.mathworks.com/matlab/2022/09/15/an-introduction-to-dictionaries-associative-arrays-in-matlab/ >   

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