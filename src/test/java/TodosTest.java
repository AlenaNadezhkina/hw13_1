import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Молоко",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);

    }

    @Test
    public void test5() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);

    }

    @Test
    public void test6() {
        Meeting meeting = new Meeting(5,
                "новая задача", "работа", "01.01.25");

        boolean actual = meeting.matches("новая задача");
        Assertions.assertTrue(actual);

    }

    @Test
    public void test7() {
        Meeting meeting = new Meeting(5,
                "новая задача", "работа", "01.01.25");

        boolean actual = meeting.matches("нет задач");
        Assertions.assertFalse(actual);
    }

    @Test
    public void test8() {
        Meeting meeting = new Meeting(5,
                "новая задача", "работа", "01.01.25");

        boolean actual = meeting.matches("работа");
        Assertions.assertTrue(actual);
    }

    @Test
    public void test9() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String actualTitle = simpleTask.getTitle();
        assertEquals("Позвонить родителям", actualTitle);
    }

    @Test
    public void test10() {
        Meeting meeting = new Meeting(5,
                "новая задача", "работа", "01.01.25");
        String actualTitle = meeting.getTitle();
        assertEquals("новая задача", actualTitle);
    }

    @Test
    public void test11() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String[] actualTitle = epic.getTitle();
        Assertions.assertArrayEquals(subtasks, actualTitle);
    }

    @Test
    public void test12() {
        Task task = new Task(4);
        int actualId = task.getId();
        assertEquals(4, actualId);
    }

    @Test
    public void test13() {
        Task task = new Task(5);
        boolean actual = task.matches("работа");
        Assertions.assertFalse(actual);
    }

    @Test
    public void test14() {
        Task task = new Task(5);
        int actual = task.hashCode();
        assertEquals(36, actual);
    }


    @Test
    public void test15() {
        Task obj = new Task(5);
        Assertions.assertTrue(obj.equals(obj));
    }

    @Test
    public void tes16() {
        Task obj = new Task(5);
        Assertions.assertFalse(obj.equals(null));
    }

    @Test
    void test17() {
        Task obj = new Task(5);
        Assertions.assertFalse(obj.equals(new Object()));
    }

    @Test
    public void test18() {
        Task obj1 = new Task(5);
        Task obj2 = new Task(6);
        Assertions.assertFalse(obj1.equals(obj2));
    }

    @Test
    public void test19() {
        Task obj1 = new Task(5);
        Task obj2 = new Task(5);
        Assertions.assertTrue(obj1.equals(obj2)); // Проверка, что obj1 == obj2
        Assertions.assertTrue(obj2.equals(obj1)); // Проверка, что obj2 == obj1
    }
}