package xyz.sluggard.transmatch.service.impl;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import xyz.sluggard.transmatch.event.EngineListener;
import xyz.sluggard.transmatch.service.EventService;

public abstract class AbstractEventService implements EventService {

	private Set<EngineListener> listeners;

	public AbstractEventService() {
		super();
		listeners = new ConcurrentSkipListSet<>();
	}

	@Override
	public void addListener(EngineListener listener) {
		if (listener == null)
            throw new NullPointerException();
		listeners.add(listener);
	}

	@Override
	public int countLinsteners() {
		return listeners.size();
	}

	@Override
	public Set<EngineListener> getLinsteners() {
		return Collections.unmodifiableSet(listeners);
	}
	
}

