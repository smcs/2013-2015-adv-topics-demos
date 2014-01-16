//
//  SBHead.h
//  Follow the Finger
//
//  Created by Seth Battis on 3/30/11.
//  Copyright 2011 Milken Community High School. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface SBHead : NSObject {
	float spin, target;
}

-(void)draw;
-(void)spin:(float)degrees;

@end
