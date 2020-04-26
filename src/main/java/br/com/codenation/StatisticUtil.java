package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return Double.valueOf(IntStream.of(elements).average().getAsDouble()).intValue();
	}

	public static int mode(int[] elements) {
		AtomicInteger maiorValor = new AtomicInteger(0);
		AtomicInteger quantidade = new AtomicInteger(0);
		
		IntStream.of(elements).forEach(i -> {
			AtomicInteger ocorrencias = new AtomicInteger(0);
			
			IntStream.of(elements).forEach(j -> {
				if (i == j) ocorrencias.incrementAndGet();
			});

	        if (ocorrencias.get() > quantidade.get()) {
	            quantidade.set(ocorrencias.get());
	            maiorValor.set(i);
	        }
		});

	    return maiorValor.get();
	}

	public static int median(int[] elements) {
		List<Integer> lista = Arrays.stream(elements).boxed().collect(Collectors.toList());
		
		Collections.sort(lista);
		
		int meio = elements.length / 2;
		if (elements.length % 2 == 1) {
			return lista.get(meio);
		} else {
			return (lista.get(meio - 1) + lista.get(meio)) / 2;
		}
	}
}
