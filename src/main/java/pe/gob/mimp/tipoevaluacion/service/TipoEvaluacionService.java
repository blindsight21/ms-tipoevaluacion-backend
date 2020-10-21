/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoevaluacion.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.tipoevaluacion.bean.FindByParamBean;
import pe.gob.mimp.tipoevaluacion.bean.TipoEvaluacionBean;

/**
 *
 * @author Omar
 */
public interface TipoEvaluacionService {
    
    void crearTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) throws Exception;
    
    void editarTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) throws Exception;
    
//    void anularTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) throws Exception;
    
    String obtenerTipoEvaluacionPorId(BigDecimal nidTipoEvaluacion) throws Exception;
    
    List<TipoEvaluacionBean> loadTipoEvaluacionList(FindByParamBean findByParamBean) throws Exception;
    
    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;
    
    TipoEvaluacionBean find(BigDecimal id) throws Exception;
}
