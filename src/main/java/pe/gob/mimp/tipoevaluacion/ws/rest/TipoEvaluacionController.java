/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoevaluacion.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.tipoevaluacion.bean.FindByParamBean;

import pe.gob.mimp.tipoevaluacion.bean.ResponseData;
import pe.gob.mimp.tipoevaluacion.bean.TipoEvaluacionBean;
import pe.gob.mimp.tipoevaluacion.service.TipoEvaluacionService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class TipoEvaluacionController {

    @Autowired
    private TipoEvaluacionService tipoEvaluacionService;

    @PostMapping(value = "/crearTipoEvaluacion", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoEvaluacion(@RequestBody TipoEvaluacionBean tipoEvaluacionBean) throws Exception {

        tipoEvaluacionService.crearTipoEvaluacion(tipoEvaluacionBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoEvaluacion", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoEvaluacion(@RequestBody TipoEvaluacionBean tipoEvaluacionBean) throws Exception {

        tipoEvaluacionService.editarTipoEvaluacion(tipoEvaluacionBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoEvaluacionPorId/{nidTipoEvaluacion}")
    public ResponseEntity<ResponseData<?>> obtenerTipoEvaluacionPorId(@PathVariable("nidTipoEvaluacion") BigDecimal nidTipoEvaluacion) throws Exception {

        String txtTipoEvaluacion = tipoEvaluacionService.obtenerTipoEvaluacionPorId(nidTipoEvaluacion);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoEvaluacion);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadTipoEvaluacionList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadTipoEvaluacionList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<TipoEvaluacionBean> tipoEvaluacionList = tipoEvaluacionService.loadTipoEvaluacionList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoEvaluacionList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = tipoEvaluacionService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoEvaluacionBean tipoEvaluacionBean = tipoEvaluacionService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoEvaluacionBean);

        return ResponseEntity.ok(response);

    }

}
