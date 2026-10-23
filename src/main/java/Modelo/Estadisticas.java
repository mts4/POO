package Modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Estadisticas {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;
	private TipoApuesta tipoMasJugado;
	private List<Resultado> historial;

	public Estadisticas(List<Resultado> historial) {
		this.historial = (historial != null) ? historial : new ArrayList<>();
		this.totalJugadas = evaluarTotalJugadas();
		this.victorias = contarVictorias();
		this.porcentajeVictorias = calcularPorcentaje();
		this.rachaMaxima = evaluarRachaMaxima();
		this.tipoMasJugado = determinarTipoMasJugado();
	}

	public int getTotalJugadas() {
		return this.totalJugadas;
	}

	public int getVictorias() {
		return this.victorias;
	}

	public double getPorcentajeVictorias() {
		return this.porcentajeVictorias;
	}

	public int getRachaMaxima() {
		return this.rachaMaxima;
	}

	public TipoApuesta getTipoMasJugado() {
		return this.tipoMasJugado;
	}

	private int evaluarTotalJugadas() {
		return this.historial.size();
	}

	private int contarVictorias() {
		int conteo = 0;
		for (Resultado r : this.historial) {
			if (r.isAcierto()) {
				conteo++;
			}
		}
		return conteo;
	}

	private double calcularPorcentaje() {
		if (this.totalJugadas == 0) {
			return 0.0;
		}
		return ((double) this.victorias / this.totalJugadas) * 100.0;
	}

	private int evaluarRachaMaxima() {
		int rachaActual = 0;
		int maxima = 0;
		for (Resultado r : this.historial) {
			if (r.isAcierto()) {
				rachaActual++;
				if (rachaActual > maxima) {
					maxima = rachaActual;
				}
			} else {
				rachaActual = 0; // Se rompe la racha
			}
		}
		return maxima;
	}

	private TipoApuesta determinarTipoMasJugado() {
		if (this.historial.isEmpty()) {
			return null;
		}

		Map<TipoApuesta, Integer> frecuencias = new HashMap<>();
		for (Resultado r : this.historial) {
			TipoApuesta tipo = r.getTipo();
			frecuencias.put(tipo, frecuencias.getOrDefault(tipo, 0) + 1);
		}

		TipoApuesta masFrecuente = null;
		int maxFrecuencia = -1;

		for (Map.Entry<TipoApuesta, Integer> entry : frecuencias.entrySet()) {
			if (entry.getValue() > maxFrecuencia) {
				maxFrecuencia = entry.getValue();
				masFrecuente = entry.getKey();
			}
		}
		return masFrecuente;
	}

}