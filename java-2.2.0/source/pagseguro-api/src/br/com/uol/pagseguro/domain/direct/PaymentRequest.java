package br.com.uol.pagseguro.domain.direct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Commission;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.SenderDocument;
import br.com.uol.pagseguro.domain.Shipping;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.enums.PaymentMode;
import br.com.uol.pagseguro.enums.ShippingType;

/**
 * Represents the payment request
 */
public abstract class PaymentRequest {

    /**
     * Payment Mode
     */
    private PaymentMode paymentMode;

    /**
     * Receiver E-Mail
     */
    private String receiverEmail;

    /**
     * Currency
     */
    private Currency currency;

    /**
     * Notification URL
     */
    private String notificationURL;

    /**
     * Reference
     */
    private String reference;

    /**
     * Sender
     */
    private Sender sender;

    /**
     * Shipping
     */
    private Shipping shipping;

    /**
     * Extra Amount
     */
    private BigDecimal extraAmount;

    /**
     * Items
     */
    private List<Item> items;

    /**
     * Commission
     */
    private Commission commission;

    /**
     * @return the payment mode
     */
    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    /**
     * @param paymentMode
     *            the payment mode to set
     */
    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * @return the receiverEmail
     */
    public String getReceiverEmail() {
        return receiverEmail;
    }

    /**
     * @param receiverEmail
     *            the receiverEmail to set
     */
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the notification URL
     */
    public String getNotificationURL() {
        return notificationURL;
    }

    /**
     * @param notificationUrl
     *            the notification URL to set
     */
    public void setNotificationURL(String notificationURL) {
        this.notificationURL = notificationURL;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference
     *            the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the sender
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * @param sender
     *            the sender to set
     */
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * @return the shipping
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * @param shipping
     *            the shipping to set
     */
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * Sets the shipping address for this direct payment request
     * 
     * @param address
     */
    public void setShippingAddress(Address address) {
        if (shipping == null) {
            shipping = new Shipping();
        }
        shipping.setAddress(address);
    }

    /**
     * Sets the shipping type for this direct payment request
     * 
     * @see ShippingType
     * 
     * @param type
     */
    public void setShippingType(ShippingType type) {
        if (shipping == null) {
            shipping = new Shipping();
        }
        shipping.setType(type);
    }

    /**
     * Sets the shipping cost for this direct payment request
     * 
     * @param cost
     */
    public void setShippingCost(BigDecimal cost) {
        if (shipping == null) {
            shipping = new Shipping();
        }
        shipping.setCost(cost);
    }

    /**
     * @return the extraAmount
     */
    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    /**
     * @param extraAmount
     *            the extraAmount to set
     */
    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<Item>();
        }
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Adds a new product/item in this direct payment request
     * 
     * @see Item
     * 
     * @param item
     */
    public void addItem(Item item) {
        getItems().add(item);
    }

    /**
     * @return the commission
     */
    public Commission getCommission() {
        return commission;
    }

    /**
     * @param commission
     *            the commission to set
     */
    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public Map<Object, Object> getMap() {
        final Map<Object, Object> data = new HashMap<Object, Object>();

        /**
         * @see PaymentMode
         */
        if (paymentMode != null) {
            data.put("paymentMode", paymentMode.getValue());
        }

        if (receiverEmail != null) {
            data.put("receiverEmail", receiverEmail);
        }

        /**
         * @see Currency
         */
        if (currency != null) {
            data.put("currency", currency);
        }

        if (notificationURL != null) {
            data.put("notificationURL", notificationURL);
        }

        if (reference != null) {
            data.put("reference", reference);
        }

        /**
         * @see Sender
         */
        if (sender != null) {
            if (sender.getEmail() != null) {
                data.put("senderEmail", sender.getEmail());
            }

            if (sender.getName() != null) {
                data.put("senderName", sender.getName());
            }

            /**
             * @see Document
             */
            final List<SenderDocument> documents = sender.getDocuments();
            if (documents != null && !documents.isEmpty()) {
                for (SenderDocument document : documents) {
                    if (DocumentType.CPF.equals(document.getType()) && document.getValue() != null) {
                        data.put("senderCPF", document.getValue());
                    } else if (DocumentType.CNPJ.equals(document.getType()) && document.getValue() != null) {
                        data.put("senderCNPJ", document.getValue());
                    }
                }
            }

            /**
             * @see Phone
             */
            final Phone phone = sender.getPhone();
            if (phone != null) {
                if (phone.getAreaCode() != null) {
                    data.put("senderAreaCode", phone.getAreaCode());
                }

                if (phone.getNumber() != null) {
                    data.put("senderPhone", phone.getNumber());
                }
            }

            if (sender.getHash() != null) {
                data.put("senderHash", sender.getHash());
            }

            if (sender.getIp() != null) {
                data.put("senderIp", sender.getIp());
            }
        }

        /**
         * @see Shipping
         */
        if (shipping != null) {
            /**
             * @see Address
             */
            final Address address = shipping.getAddress();
            if (address != null) {
                if (address.getPostalCode() != null) {
                    data.put("shippingAddressPostalCode", address.getPostalCode());
                }

                if (address.getStreet() != null) {
                    data.put("shippingAddressStreet", address.getStreet());
                }

                if (address.getNumber() != null) {
                    data.put("shippingAddressNumber", address.getNumber());
                }

                if (address.getComplement() != null) {
                    data.put("shippingAddressComplement", address.getComplement());
                }

                if (address.getDistrict() != null) {
                    data.put("shippingAddressDistrict", address.getDistrict());
                }

                if (address.getCity() != null) {
                    data.put("shippingAddressCity", address.getCity());
                }

                if (address.getState() != null) {
                    data.put("shippingAddressState", address.getState());
                }

                if (address.getCountry() != null) {
                    data.put("shippingAddressCountry", address.getCountry());
                }
            }

            if (shipping.getType() != null) {
                data.put("shippingType", shipping.getType().getValue());
            }

            if (shipping.getCost() != null) {
                data.put("shippingCost", shipping.getCost());
            }
        }

        if (extraAmount != null) {
            data.put("extraAmount", extraAmount);
        }

        /**
         * @see Item
         */
        if (items != null && !items.isEmpty()) {
            int count = 1;

            for (Item item : items) {
                if (item.getId() != null && !"".equals(item.getId())) {
                    data.put("itemId" + count, item.getId());
                }

                if (item.getDescription() != null && !"".equals(item.getDescription())) {
                    data.put("itemDescription" + count, item.getDescription());
                }

                if (item.getQuantity() != null && item.getQuantity() > 0) {
                    data.put("itemQuantity" + count, item.getQuantity());
                }

                if (item.getAmount() != null) {
                    data.put("itemAmount" + count, item.getAmount());
                }

                count++;
            }
        }

        /**
         * @see Commission
         */
        if (commission != null) {
            if (commission.getRate() != null) {
                data.put("commissionRate", commission.getRate());
            }

            if (commission.getDescription() != null) {
                data.put("commissionDescription", commission.getDescription());
            }
        }

        return data;
    };

}
