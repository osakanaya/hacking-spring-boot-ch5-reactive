package com.greglturnquist.hackingspringbootch5reactive;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

public class SpringDataHttpTraceRepository implements HttpTraceRepository {

	private final HttpTraceWrapperRepository repository;
	
	public SpringDataHttpTraceRepository(HttpTraceWrapperRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<HttpTrace> findAll() {
		return repository.findAll()
			.map(HttpTraceWrapper::getHttTrace).collect(Collectors.toList());
	}

	@Override
	public void add(HttpTrace trace) {
		repository.save(new HttpTraceWrapper(trace));
	}

}
