package com.nttdata.glue;

import com.nttdata.steps.ServicioStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ServicioStoreStepDef {
    @Steps
    ServicioStoreStep servicioStoreStep;

    @Given("ingrese a la pagina web")
    public void ingreseALaPaginaWeb() {
    }

    @When("creo el order con el id {string}, el petId {string}, la cantidad {string}, la fecha de envio {string}, el estado {string} y si fue completado {string}")
    public void creoElOrderConElIdElPetIdLaCantidadLaFechaDeEnvioElEstadoYSiFueCompletado(String id, String petId, String cantidad, String fechaenvio, String estado, String completado) {
        servicioStoreStep.agregarOrder(id,petId,cantidad,fechaenvio,estado,completado);
    }

    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int estado) {
        servicioStoreStep.validaCodStatusDeAgregar(estado);
    }


    @Given("ingrese a la pagina web pestore")
    public void ingreseALaPaginaWebPestore() {

    }

    @When("hago la consulta del id {string}")
    public void hagoLaConsultaDelId(String id) {
        servicioStoreStep.consultarOrder(id);
    }

    @Then("el codigo de respuesta mostrado es {int}")
    public void elCodigoDeRespuestaMostradoEs(int estado) {
        servicioStoreStep.validaCodStatusDeConsulta(estado);
    }

    @And("valido el body con el id {string}, el petId {string}, la cantidad {string}, la fecha de envio {string}, el estado {string} y si fue completado {string}")
    public void validoElBodyConElIdElPetIdLaCantidadLaFechaDeEnvioElEstadoYSiFueCompletado(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        servicioStoreStep.validaBodyDeConsulta(arg0,arg1,arg2,arg3,arg4,arg5);
    }

    @And("valido el body e la creacion con el id {string}, el petId {string}, la cantidad {string}, la fecha de envio {string}, el estado {string} y si fue completado {string}")
    public void validoElBodyELaCreacionConElIdElPetIdLaCantidadLaFechaDeEnvioElEstadoYSiFueCompletado(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        servicioStoreStep.validaBodyDeAgregar(arg0,arg1,arg2,arg3,arg4,arg5);
    }
}
