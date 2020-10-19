package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 如果HashMap需要存储自定义数据类型为key，则当前自定义数据类型默认使用 引用address 作为key
 * 如果想要自定义key属性，需要重写自定义数据类型中的 boolean equals(Object o) 和 int hashCode() 函数
 */
public class HashCode {

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Max");
        Student student2 = new Student("Max");
        System.out.println(student1.equals(student2));

        Map<Integer, Integer> map1 = new HashMap<>();
        int a = 1, b = 1;
        map1.put(a, 3);
        System.out.println(map1.get(b));

        Map<Student, Integer> map2 = new HashMap<>();
        map2.put(student1, 3);
        System.out.println(map2.get(student2));
    }
}
