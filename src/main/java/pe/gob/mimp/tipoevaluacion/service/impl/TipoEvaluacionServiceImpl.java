/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoevaluacion.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.TipoEvaluacion;
import pe.gob.mimp.siscap.repository.tipoevaluacion.TipoEvalRepository;
import pe.gob.mimp.tipoevaluacion.bean.FindByParamBean;
import pe.gob.mimp.tipoevaluacion.bean.TipoEvaluacionBean;
import pe.gob.mimp.tipoevaluacion.converter.TipoEvaluacionCast;
import pe.gob.mimp.tipoevaluacion.util.Util;
import pe.gob.mimp.tipoevaluacion.service.TipoEvaluacionService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoEvaluacionServiceImpl implements TipoEvaluacionService {

    @Autowired
    private TipoEvalRepository tipoEvaluacionRepository;

    @Override
    public void crearTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) throws Exception {

        tipoEvaluacionRepository.save(TipoEvaluacionCast.castTipoEvaluacionBeanToTipoEvaluacion(tipoEvaluacionBean));

    }

    @Override
    public void editarTipoEvaluacion(TipoEvaluacionBean tipoEvaluacionBean) {

        if (tipoEvaluacionBean.getNidTipoEvaluacion() == null) {
            return;
        }

        tipoEvaluacionRepository.save(TipoEvaluacionCast.castTipoEvaluacionBeanToTipoEvaluacion(tipoEvaluacionBean));

    }

    @Override
    public String obtenerTipoEvaluacionPorId(BigDecimal nidTipoEvaluacion) throws Exception {

        Optional<TipoEvaluacion> tipoEvaluacion = tipoEvaluacionRepository.findById(nidTipoEvaluacion);

        if (tipoEvaluacion.isPresent()) {
            return tipoEvaluacion.get().getTxtTipoEvaluacion();
        }

        return "";
    }

    @Override
    public List<TipoEvaluacionBean> loadTipoEvaluacionList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<TipoEvaluacion> tipoEvaluacionList = tipoEvaluacionRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(tipoEvaluacionList)) {

            return tipoEvaluacionList.stream().map(tipoEvaluacion -> {

                return TipoEvaluacionCast.castTipoEvaluacionToTipoEvaluacionBean(tipoEvaluacion);

            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = tipoEvaluacionRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public TipoEvaluacionBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<TipoEvaluacion> tipoEvaluacion = tipoEvaluacionRepository.findById(id);

        if (!tipoEvaluacion.isPresent()) {
            return null;
        }

        return TipoEvaluacionCast.castTipoEvaluacionToTipoEvaluacionBean(tipoEvaluacion.get());

    }

}
