package denis.lishchuk.java_test.validators;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, FirstGroup.class, SecondGroup.class})
public interface ValidationSequence {
}
