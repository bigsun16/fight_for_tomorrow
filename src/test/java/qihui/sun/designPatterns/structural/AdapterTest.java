package qihui.sun.designPatterns.structural;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.structural.adapter.LogAdapter;
import qihui.sun.designPatterns.structural.adapter.NewLogImpl;
import qihui.sun.designPatterns.structural.adapter.OldLog;

public class AdapterTest {
    @Test
    public void test() {
        OldLog log = new LogAdapter(new NewLogImpl());
        log.log();
    }
}
