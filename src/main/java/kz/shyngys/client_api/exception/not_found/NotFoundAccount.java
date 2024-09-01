package kz.shyngys.client_api.exception.not_found;

public class NotFoundAccount extends AbstractNotFoundException {

    public NotFoundAccount(Object id) {
        super(id);
    }

}
