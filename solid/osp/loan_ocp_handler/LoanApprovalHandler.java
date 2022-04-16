package solid.osp.loan_ocp_handler;

public class LoanApprovalHandler {
    public void approveLoan(Validator validator) {
        if (validator.isValid()) {
            System.out.println("Something doing ...");
        }
    }
}
