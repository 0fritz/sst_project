package ro.uvt.dp.Decorator;

import ro.uvt.dp.Client.Client;

public class LifeInsurancePromotion implements Promotion {
    private Client client;

    public LifeInsurancePromotion(Client client) {
        this.client = client;
        applyPromotion();
    }

    @Override
    public void applyPromotion() {
        System.out.println("Life Insurance Promotion applied for the client: " + client.getName());
        client.getClientPromotions().forEach(Promotion::applyPromotion);
    }
}
