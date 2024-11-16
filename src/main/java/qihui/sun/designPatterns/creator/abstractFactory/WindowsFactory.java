package qihui.sun.designPatterns.creator.abstractFactory;

public class WindowsFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}
