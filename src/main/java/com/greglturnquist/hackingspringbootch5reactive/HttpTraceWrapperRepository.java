package com.greglturnquist.hackingspringbootch5reactive;

import java.util.stream.Stream;

import org.springframework.data.repository.Repository;

public interface HttpTraceWrapperRepository extends Repository<HttpTraceWrapper, String> {
	Stream<HttpTraceWrapper> findAll();
	void save(HttpTraceWrapper trace);
}
