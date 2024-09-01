package kz.shyngys.client_api.exception.not_found;

public class NotFoundAccountLimit extends AbstractNotFoundException {

    public NotFoundAccountLimit(Object id) {
        super(id);
    }

}
