package br.com.fiap;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Aluno {
	
	private int rm;
	private String nome;
	private LocalDate dataDeNascimento;
		
	public Aluno() {
	}

	public Aluno(int rm, String nome, LocalDate dataDeNascimento) {
		this.rm = rm;
		this.nome = nome;
		setDataDeNascimento(dataDeNascimento);
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		
		try {
			if (rm >=97001 && rm<=551999) {
				this.rm=rm;
			} else {
				throw new Exception("RM Fora da faixa permitida");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		int anoAtual = LocalDate.now().getYear();
		try {
			
			if (dataDeNascimento.getYear() >= 1900 && dataDeNascimento.getYear() <= anoAtual) {
				this.dataDeNascimento=dataDeNascimento;
			} else {
				throw new Exception("Ano de nascimento invalido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}
	
	public String calculaIdadeCompleta(LocalDate dataAtual) {
        Period periodo = Period.between(dataDeNascimento, dataAtual);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        return anos + " anos, " + meses + " meses e " + dias + " dias";
    }
}

