package org.jbehave.osgi.examples.trader.pomfirst.paxexam.embedder;

import org.jbehave.osgi.core.annotations.UsingStoryRunnerServiceFilter;
import org.jbehave.osgi.examples.trader.pomfirst.paxexam.AbstractExampleTestConfiguration;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

/**
 * This example uses the PAX-Exam test framework to instantiate an OSGi
 * environment, install the test bundles and execute the required stories.
 * <p>
 * 
 * This option uses of the {@link @UsingStoryRunnerServiceFilter} filter, that
 * binds all specified runner services and call them run() method.
 * 
 * @author cvgaviao
 *
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
@UsingStoryRunnerServiceFilter(filter = "(&(objectClass=StoryRunnerService)(storyRunnerClass=*))")
public class PaxExamLauncherForJBehaveOption3 extends
        AbstractExampleTestConfiguration {

    public PaxExamLauncherForJBehaveOption3() {
    }

}