package com.polo.rest.polo.dto;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parents;

public class ConvertionManager
{

    private static ConvertionManager convertionManagerInstance = null;
    private ConvertionManager() {}
    
    public static ConvertionManager getConvertionManager() {
        
        if ( null == convertionManagerInstance ) {
            convertionManagerInstance = new ConvertionManager();
        }
        
        return convertionManagerInstance;
    }
    
    public AccountDto convertAccountToDto( Account entityAccount) {
        AccountDto dtoAccount = new AccountDto();
        
        dtoAccount.setName( entityAccount.getName() );
        dtoAccount.setCardId( entityAccount.getCardId() );
        dtoAccount.setPostalCode( entityAccount.getPostalCode() );
        dtoAccount.setBirthday( entityAccount.getBirthday() );
        dtoAccount.setGender( entityAccount.getGender() );
        dtoAccount.setMobileNumber( entityAccount.getMobileNumber() );
        dtoAccount.setLevel( entityAccount.getLevel() );
        dtoAccount.setSize( entityAccount.getSize() );
        dtoAccount.setObservations( entityAccount.getObservations() );
        dtoAccount.setCc( entityAccount.isCc() );
        dtoAccount.setExam( entityAccount.isExam() );
        dtoAccount.setEnrolled( entityAccount.isEnrolled() );

        dtoAccount.setParentsDto( convertParentsToDto( entityAccount.getParents() ) );
        
        return dtoAccount;
    }
    
    private ParentsDto convertParentsToDto( Parents parents ) {
        ParentsDto dtoParents = new ParentsDto();
        dtoParents.setName( parents.getName() );
        dtoParents.setEmail( parents.getEmail() );
        dtoParents.setMobileNumber( parents.getMobileNumber() );
        
        return dtoParents;
    }
    
    public Account convertAccountToEntity( AccountDto dtoAccount) {
        Account entityAccount = new Account();
        
        entityAccount.setName( dtoAccount.getName() );
        entityAccount.setCardId( dtoAccount.getCardId() );
        entityAccount.setPostalCode( dtoAccount.getPostalCode() );
        entityAccount.setBirthday( dtoAccount.getBirthday() );
        entityAccount.setGender( dtoAccount.getGender() );
        entityAccount.setMobileNumber( dtoAccount.getMobileNumber() );
        entityAccount.setLevel( dtoAccount.getLevel() );
        entityAccount.setSize( dtoAccount.getSize() );
        entityAccount.setObservations( dtoAccount.getObservations() );
        entityAccount.setCc( dtoAccount.isCc() );
        entityAccount.setExam( dtoAccount.isExam() );
        entityAccount.setEnrolled( dtoAccount.isEnrolled() );

        entityAccount.setParents( convertParentsDtoToEntity( dtoAccount.getParentsDto() ) );
        
        return entityAccount;
    }
    
    private Parents convertParentsDtoToEntity( ParentsDto dtoParents ) {
        Parents entityParents = new Parents();
        entityParents.setName( dtoParents.getName() );
        entityParents.setEmail( dtoParents.getEmail() );
        entityParents.setMobileNumber( dtoParents.getMobileNumber() );
        
        return entityParents;
    }
    
}
