package techin.lt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page extends Base{
    public Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    WebElement createAccount;
    @FindBy(css = "input#username")
    WebElement registerUsername;
    @FindBy(css = "input#password")
    WebElement registerPassword;
    @FindBy(css = "input#passwordConfirm")
    WebElement registerConfirmPassword;
    @FindBy(xpath = "//form[@id='userForm']/button[@type='submit']")
    WebElement createButton;
    @FindBy(css = "#username\\.errors")
    WebElement usernameError;
    @FindBy(css = "input[name='username']")
    WebElement loginUsername;
    @FindBy(css = "input[name='password']")
    WebElement loginPassword;
    @FindBy(xpath = "/html//form[@action='/prisijungti']//button[@type='submit']")
    WebElement loginButton;
    @FindBy(css = "div > span:nth-of-type(2)")
    WebElement loginError;
    @FindBy(css = "[name='sk1']")
    WebElement firstNumber;
    @FindBy(css = "[name='sk2']")
    WebElement secondNumber;
    @FindBy(css = "[type='submit']")
    WebElement calculate;
    @FindBy(css = "#sk1\\.errors")
    WebElement numberError;
    @FindBy(css = "[href='\\/skaiciai']")
    WebElement doneOperations;
    @FindBy(css = "tbody tr:nth-of-type(2)")
    WebElement firstResult;
    public void clickCreateAccount(){
        createAccount.click();
    }
    public void inputRegisterUsername(String username){
        registerUsername.sendKeys(username);
    }
    public void inputRegisterPassword(String password){
        registerPassword.sendKeys(password);
    }
    public void inputRegisterConfirmPassword(String confirmPassword){
        registerConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickCreateButton(){
        createButton.click();
    }
    public String assertUsernameError(){
        return usernameError.getText();
    }
    public void inputLoginUsername(String username){
        loginUsername.sendKeys(username);
    }
    public void inputLoginPassword(String password){
        loginPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String assertLoginError(){
        return loginError.getText();
    }
    public void inputFirstNumber(String number){
        firstNumber.sendKeys(number);
    }
    public void inputSecondNumber(String number){
        secondNumber.sendKeys(number);
    }
    public void clickCalculate(){
        calculate.click();
    }
    public void clearFirstNumber(){
        firstNumber.clear();
    }
    public void clearSecondNumber(){
        secondNumber.clear();
    }
    public String assertNumberError(){
        return numberError.getText();
    }
    public void clickDoneOperations(){
        doneOperations.click();
    }
    public String getFirstResult(){
        return firstResult.getText();
    }
}
