package customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCaseInfo {
	String id();

	public enum severity {
		HIGH("high"), MEDIUN("medium"), LOW("low");

		final String severity;

		severity(String severity) {
			this.severity = severity;
		}

		public String toString() {
			return severity;
		}
	}
}
