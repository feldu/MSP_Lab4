1. Для своей программы из [лабораторной работы №4 по дисциплине "Программирование интернет-приложений"](https://github.com/feldu/Lab4_Web) реализовать:
    * MBean, считающий общее число установленных пользователем точек, а также число точек, не попадающих в область. В случае, если количество установленных пользователем точек стало кратно 5, разработанный MBean должен отправлять оповещение об этом событии.
    * MBean, определяющий процентное отношение "промахов" к общему числу кликов пользователя по координатной плоскости.
2. С помощью утилиты JConsole провести мониторинг программы:
    * Снять показания MBean-классов, разработанных в ходе выполнения задания 1.
    * Определить версию Java Language Specification, реализуемую данной средой исполнения.
3. С помощью утилиты VisualVM провести мониторинг и профилирование программы:
    * Снять график изменения показаний MBean-классов, разработанных в ходе выполнения задания 1, с течением времени.
    * Определить имя класса, объекты которого занимают наибольший объём памяти JVM; определить пользовательский класс, в экземплярах которого находятся эти объекты.
4. Получить HeapDump, и с помощью утилиты VisualVM локализовать и устранить "утечку памяти" в программе ниже:

<details> 
  <summary>Код программы</summary>
  
```java
// var. 19582
public class Lab4 {
  public static void main(String[] args) {
    E a = new E();
    E b = new B();
    B c = new B();
    b.t38();
    b.t34();
    b.t3();
    a.t12();
    a.t22();
    a.t1();
    a.t7();
    c.t14();
    a.t20();
    c.t37();
    c.t16(a);
    c.t16(b);
    c.t16(c);
    c.t42();
    c.t47();
    c.t11();
    Thread t = new Thread(new Runnable() {
      public void run() {
        while(true) {
          try {
             B d = new B();
             d.t43();
             Thread.sleep(8);
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
}
class E {
  int t24;
  int t45;
  int t2;
  int t4;
  int t49;
  long t23;
  long t32;
  long t26;
  java.io.ObjectOutputStream fileStrm;
  java.io.ObjectOutputStream helloWorldWrtr;
  java.io.ObjectOutputStream stringsStrm;
  int[] t10 = {1, 2, 2, -1};
  int[] t18 = {0, 1, -3, -1};
  int[] t36 = {2, -2, 0, 1, 0};
  static java.util.Map<java.net.URI,byte[]> cache = new java.util.HashMap<>();
  static int t21;
  static int t44;
  static int t50;
  static int t39;
  static int t33;
  java.util.List<String> t19 = new java.util.ArrayList<>();
  java.util.List<String> t13 = new java.util.ArrayList<>();
  java.util.List<String> t30 = new java.util.ArrayList<>();
  public E() {
    t24 = 5;
    t45 = 3;
    t2 = 4;
    t4 = 7;
    t49 = 1;
    t23 = 0L;
    t32 = 6L;
    t26 = 2L;
    try {
        fileStrm = new java.io.ObjectOutputStream(new java.io.FileOutputStream("fileStrm.txt"));
        helloWorldWrtr = new java.io.ObjectOutputStream(new java.io.FileOutputStream("helloWorldWrtr.txt"));
        stringsStrm = new java.io.ObjectOutputStream(new java.io.FileOutputStream("stringsStrm.txt"));
    } catch (java.lang.Exception e) {
      // Do nothing
    }
  }
  public void init() {
    try {
      if (fileStrm == null) fileStrm = new java.io.ObjectOutputStream(new java.io.FileOutputStream("fileStrm.txt"));
      System.out.println("Thread : " + Thread.currentThread() + ", fileStrm = " + fileStrm);
    } catch(Exception e) {
      // Ignore it
    }
    try {
      if (helloWorldWrtr == null) helloWorldWrtr = new java.io.ObjectOutputStream(new java.io.FileOutputStream("helloWorldWrtr.txt"));
      System.out.println("Thread : " + Thread.currentThread() + ", helloWorldWrtr = " + helloWorldWrtr);
    } catch(Exception e) {
      // Ignore it
    }
    try {
      if (stringsStrm == null) stringsStrm = new java.io.ObjectOutputStream(new java.io.FileOutputStream("stringsStrm.txt"));
      System.out.println("Thread : " + Thread.currentThread() + ", stringsStrm = " + stringsStrm);
    } catch(Exception e) {
      // Ignore it
    }
  }
  public byte[] getValueFromCache(String s) {
    try {
      java.net.URI url = new java.net.URI(s);
      if(!cache.containsKey(url)) {
        cache.put(url, new byte[262144]);
      }
      return cache.get(url);
    } catch (Exception e) {
      System.out.println("Error: invalid URL!");
      return null;
    }
  }
  public void t38() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(fileStrm) {
              fileStrm.writeObject("метод t38 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(5);
              fileStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t34() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(helloWorldWrtr) {
              helloWorldWrtr.writeObject("метод t34 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(6);
              helloWorldWrtr.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t3() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(stringsStrm) {
              stringsStrm.writeObject("метод t3 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(5);
              stringsStrm.flush();
              stringsStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t12() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(stringsStrm) {
              stringsStrm.writeObject("метод t12 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(5);
              stringsStrm.flush();
              stringsStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t22() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(stringsStrm) {
              stringsStrm.writeObject("метод t22 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(5);
              stringsStrm.flush();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t1() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(fileStrm) {
              fileStrm.writeObject("метод t1 в классе E (#" + String.valueOf(i) + ")");
              Thread.sleep(5);
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public static void t7() {
    System.out.println("метод t7 в классе E");
    System.out.println(t21);
  }
  public static void t14() {
    System.out.println("метод t14 в классе E");
    System.out.println((t21 - 2));
  }
  public static void t20() {
    System.out.println("метод t20 в классе E");
    System.out.println(t44);
  }
  public static void t37() {
    System.out.println("метод t37 в классе E");
    System.out.println((t44 - 2));
  }
  public void t16(E r) {
    r.t38();
  }
  public void t16(B r) {
    r.t34();
  }
}
class B extends E {
  public B() {
    t24 = 0;
    t2 = 8;
    t26 = 7L;
  }
  public void t38() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(fileStrm) {
              fileStrm.writeObject("метод t38 в классе B (#" + String.valueOf(i) + ")");
              Thread.sleep(11);
              fileStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t34() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(fileStrm) {
              fileStrm.writeObject("метод t34 в классе B (#" + String.valueOf(i) + ")");
              Thread.sleep(14);
              fileStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t22() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        init();
        int i = 0;
        while(true) {
          i++;
          try {
            synchronized(stringsStrm) {
              stringsStrm.writeObject("метод t22 в классе B (#" + String.valueOf(i) + ")");
              Thread.sleep(13);
              stringsStrm.reset();
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t42() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while(true) {
          try {
            synchronized(cache) {
              getValueFromCache("https://www.google.com");
              Thread.sleep(13);
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t47() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while(true) {
          try {
            synchronized(cache) {
              getValueFromCache("https://www.google.com");
              Thread.sleep(6);
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public void t11() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while(true) {
          try {
            synchronized(cache) {
              getValueFromCache("https://www.google.com");
              Thread.sleep(8);
            }
          } catch(Exception e) {
            // Do nothing
          }
        }
      }
    });
    t.start();
  }
  public static void t7() {
    System.out.println("метод t7 в классе B");
    System.out.println(++t21);
  }
  public static void t14() {
    System.out.println("метод t14 в классе B");
    System.out.println(t44);
  }
  public static void t20() {
    System.out.println("метод t20 в классе B");
    System.out.println((t44 + 5));
  }
  public static void t37() {
    System.out.println("метод t37 в классе B");
    System.out.println(t44);
  }
  public void t40() {
    for(int i = 0; i < 8; i++) {
      this.t30.add(String.valueOf(System.nanoTime()));
      // System.out.println(this.t30.size());
    }
  }
  public void t43() {
    for(int i = 0; i < 7; i++) {
      this.t13.add(String.valueOf(System.nanoTime()));
      // System.out.println(this.t13.size());
    }
  }
  public void t8() {
    for(int i = 0; i < 7; i++) {
      this.t13.add(String.valueOf(System.nanoTime()));
      // System.out.println(this.t13.size());
    }
  }
  public void t5() {
    for(int i = 0; i < 7; i++) {
      this.t13.add(String.valueOf(System.nanoTime()));
      // System.out.println(this.t13.size());
    }
  }
  public void t16(E r) {
    r.t3();
  }
  public void t16(B r) {
    r.t12();
  }
}
```
</details>