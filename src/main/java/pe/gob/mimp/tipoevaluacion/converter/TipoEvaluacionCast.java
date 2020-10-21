/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoevaluacion.converter;

import pe.gob.mimp.siscap.model.TipoEvaluacion;
import pe.gob.mimp.tipoevaluacion.bean.TipoEvaluacionBean;

/**
 *
 * @author Omar
 */
public class TipoEvaluacionCast {

    public static TipoEvaluacionBean castTipoEvaluacionToTipoEvaluacionBean(TipoEvaluacion tipoEvaluacion) {

        if (tipoEvaluacion == null) {
            return null;
        }

        TipoEvaluacionBean tipoEvaluacionBean = new TipoEvaluacionBean();

        tipoEvaluacionBean.setNidTipoEvaluacion(tipoEvaluacion.getNidTipoEvaluacion());
        tipoEvaluacionBean.setTxtTipoEvaluacion(tipoEvaluacion.getTxtTipoEvaluacion());
        tipoEvaluacionBean.setFlgActivo(tipoEvaluacion.getFlgActivo());
        tipoEvaluacionBean.setNidUsuario(tipoEvaluacion.getNidUsuario());
        tipoEvaluacionBean.setTxtPc(tipoEvaluacion.getTxtPc());
        tipoEvaluacionBean.setTxtIp(tipoEvaluacion.getTxtIp());
        tipoEvaluacionBean.setFecEdicion(tipoEvaluacion.getFecEdicion());
        
        return tipoEvaluacionBean;
    }

    public static TipoEvaluacion castTipoEvaluacionBeanToTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) {

        if (tipoEvaluacionBean == null) {
            return null;
        }

        TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();

        tipoEvaluacion.setNidTipoEvaluacion(tipoEvaluacionBean.getNidTipoEvaluacion());
        tipoEvaluacion.setTxtTipoEvaluacion(tipoEvaluacionBean.getTxtTipoEvaluacion());
        tipoEvaluacion.setFlgActivo(tipoEvaluacionBean.getFlgActivo());
        tipoEvaluacion.setNidUsuario(tipoEvaluacionBean.getNidUsuario());
        tipoEvaluacion.setTxtPc(tipoEvaluacionBean.getTxtPc());
        tipoEvaluacion.setTxtIp(tipoEvaluacionBean.getTxtIp());
        tipoEvaluacion.setFecEdicion(tipoEvaluacionBean.getFecEdicion());

        return tipoEvaluacion;
    }
}
