package br.com.bycoffe.flowes.utils.TaskCategory;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Category {
    HOJE, AMANHA, PROXIMA_SEMANA, PROXIMO_MES
}
