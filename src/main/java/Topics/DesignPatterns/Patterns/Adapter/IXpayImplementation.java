package Topics.DesignPatterns.Patterns.Adapter;
/**
 * When to use the adapter pattern:
 * 1. There is an existing class, and its interface does not match the one you need
 * 2. You want to create a reusable class that cooperates with unrelated or incompatible classes; the classes which have potentially incompatible interfaces
 * 3. There are several existing subclasses for use, but it's impractical to adapt their interface by subclassing each one. An object adapter can adapt the interface of its
 * parent class.
 */

/**
 * Sometimes there can be scenario when two or more object types do not fit together as they should. This is mainly due to the incompatible (or lack of) interfaces of the two or more objects
 * that do not fit together. The Adapter pattern lets you adapt what an object or a class exposes to what another object or class expects. Essentially, it converts the interface
 * of a class into another interface the client expects.
 *
 * A software developer, Max, uses a 3rd party payment gateway to allow users to pay for things purchased on the piece of software he is working on. Max is using the Xpay payment
 * gateway to redirect users to a payment form. Thus, the Java code is build to only accept Xpay object types. Suppose Max wanted to change the payment gateway vendor from Xpay
 * to PayD. PayD allows only PayD object types. The solution to allow this new type of payment vendor without changing a lot of the existing code is the Adapter design pattern.
 */
interface IPayD {
    public String getCustCardNo();
    public String getCardOwnerName();
    public String getCardExpMonthDate();
    public Integer getCVVNo();
    public Double getTotalAmount();
    public void setCustCardNo(String custCardNo);
    public void setCardOwnerName(String cardOwnerName);
    public void setCardExpMonthDate(String cardExpMonthDate);
    public void setCVVNo(Integer cVVNo);
    public void setTotalAmount(Double totalAmount);
}

interface IXpay {
    String getCreditCardNo();
    String getCustomerName();
    public String getCardExpiryMonth();
    public String getCardExpiryYear();
    public Short getCardCvvNumber();
    public Double getAmount();

    public void setCreditCardNo(String creditCardNo);
    public void setCustomerName(String customerName);
    public void setCardExpMonth(String cardExpMonth);
    public void setCardExpYear(String cardExpYear);
    public void setCardCVVNo(Short cardCVVNo);
    public void setAmount(Double amount);
}

public class IXpayImplementation implements IXpay{
    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardCVVNo;
    private Double amount;

    @Override
    public String getCreditCardNo() {
        return creditCardNo;
    }
    @Override
    public String getCustomerName() {
        return customerName;
    }
    @Override
    public String getCardExpiryMonth() {
        return cardExpMonth;
    }
    @Override
    public String getCardExpiryYear() {
        return cardExpYear;
    }
    @Override
    public Short getCardCvvNumber() {
        return cardCVVNo;
    }
    @Override
    public Double getAmount() {
        return amount;
    }
    @Override
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }
    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    @Override
    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }
    @Override
    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }
    @Override
    public void setCardCVVNo(Short cardCVVNo) {
        this.cardCVVNo = cardCVVNo;
    }
    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

/**
 * As you can see, the Xpay interface has a set of different methods which need to be implemented in the code. Since Xpay is created by most of the code, it is risky and difficult
 * to change the entire set of classes. This is fixed through use of the Adapter pattern.
 */
 class XpayToPayDAdapter implements IPayD {
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;
    private final IXpay xpay;

    public XpayToPayDAdapter(IXpay xpay){
        this.xpay = xpay;
        setProp();
    }
    @Override
    public String getCustCardNo() {
        return custCardNo;
    }
    @Override
    public String getCardOwnerName() {
        return cardOwnerName;
    }
    @Override
    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }
    @Override
    public Integer getCVVNo() {
        return cVVNo;
    }
    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }
    @Override
    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }
    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }
    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }
    @Override
    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }
    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Used to set the Xpay's properties as the PayD's object properties.
     */
    private void setProp(){
        setCardOwnerName(this.xpay.getCustomerName());
        setCustCardNo(this.xpay.getCreditCardNo());
        setCardExpMonthDate(this.xpay.getCardExpiryMonth()+"/"+this.xpay.
                getCardExpiryYear());
        setCVVNo(this.xpay.getCardCvvNumber().intValue());
        setTotalAmount(this.xpay.getAmount());
    }
}
