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
	private String tipoMasJugado;
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

	public String getTipoMasJugado() {
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
				rachaActual = 0;
			}
		}
		return maxima;
	}

	private String determinarTipoMasJugado() {
		if (this.historial.isEmpty()) {
			return "Sin datos";
		}

		String masFrecuente = "Sin datos";
		int maxFrecuencia = 0;

		for (int i = 0; i < this.historial.size(); i++) {
			String apuestaActual = this.historial.get(i).getTipo().getTipoApuesta();
			int contadorActual = 0;

			for (int j = 0; j < this.historial.size(); j++) {
				String apuestaAComparar = this.historial.get(j).getTipo().getTipoApuesta();

				if (apuestaActual.equals(apuestaAComparar)) {
					contadorActual++;
				}
			}
			if (contadorActual > maxFrecuencia) {
				maxFrecuencia = contadorActual;
				masFrecuente = apuestaActual;
				}
		}
		return masFrecuente;
	}

}