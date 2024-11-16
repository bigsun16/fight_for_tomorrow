package qihui.sun.designPatterns.creator.abstractFactory;

public class LinuxFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextBox createTextBox() {
        return new LinuxTextBox();
    }
}
