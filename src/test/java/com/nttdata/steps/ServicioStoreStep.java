package com.nttdata.steps;

import com.nttdata.model.Order;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ServicioStoreStep {

    private String URL_BASE = "https://petstore.swagger.io/v2/store/order";

    public void agregarOrder(String id, String idpet, String cantidad, String fecha, String estado, String completado){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log()
                .all()
                .body("{\n" +
                        "  \"id\": "+Integer.parseInt(id)+",\n" +
                        "  \"petId\": "+Integer.parseInt(idpet)+",\n" +
                        "  \"quantity\": "+Integer.parseInt(cantidad)+",\n" +
                        "  \"shipDate\": \""+fecha+"\",\n" +
                        "  \"status\": \""+estado+"\",\n" +
                        "  \"complete\": "+Boolean.valueOf(completado)+"\n" +
                        "}")
                .post(URL_BASE)
                .then()
                .log().all();
    }

    public void validaBodyDeAgregar(String id, String idPet, String cantidad, String fecha, String estado, String completado) {
        Order order = lastResponse().as(Order.class);
        assertThat(order.getId(), is(Integer.parseInt(id)));
        assertThat(order.getPetId(), is(Integer.parseInt(idPet)));
        assertThat(order.getQuantity(), is(Integer.parseInt(cantidad)));
        assertThat(order.getShipDate(), is(fecha));
        assertThat(order.getStatus(), is(estado));
        assertThat(order.isComplete(), is(Boolean.valueOf(completado)));

        System.out.println("La validación del cuerpo de la orden agregada fue exitosa.");
    }

    public void validaCodStatusDeAgregar(int status){
        assertThat(lastResponse().statusCode(), is(status));
        System.out.println("El status es " + status);
    }

    public void consultarOrder(String id){
        Order order=
                given()
                        .baseUri(URL_BASE)
                        .log()
                        .all()
                        .when()
                        .get(id)
                        .as(Order.class);

        System.out.println("Se muestra el id " + order.getId());
        System.out.println("Se muestra el id del pet " + order.getPetId());
        System.out.println("Se muestra la fecha de envio " + order.getShipDate());

    }

    public void validaBodyDeConsulta(String id, String idPet, String cantidad, String fecha, String estado, String completado) {
        Order order = lastResponse().as(Order.class);
        assertThat(order.getId(), is(Integer.parseInt(id)));
        assertThat(order.getPetId(), is(Integer.parseInt(idPet)));
        assertThat(order.getQuantity(), is(Integer.parseInt(cantidad)));
        assertThat(order.getShipDate(), is(fecha));
        assertThat(order.getStatus(), is(estado));
        assertThat(order.isComplete(), is(Boolean.valueOf(completado)));

        System.out.println("La validación del cuerpo de la consulta fue exitosa.");
    }

    public void validaCodStatusDeConsulta(int status){
        assertThat(lastResponse().statusCode(), is(status));
        System.out.println("El status es " + status);
    }




}
