package vg.civcraft.mc.civmodcore.scheduling;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;

/**
 * A cancellable handle to a scheduled task. Wraps Paper's {@link ScheduledTask} so call sites do not
 * need to import the Folia scheduler types directly.
 */
public interface CivTask {

    void cancel();

    boolean isCancelled();

    static CivTask wrap(final ScheduledTask task) {
        return new ScheduledCivTask(task);
    }

    record ScheduledCivTask(ScheduledTask task) implements CivTask {

        @Override
        public void cancel() {
            this.task.cancel();
        }

        @Override
        public boolean isCancelled() {
            return this.task.isCancelled();
        }

    }

}
